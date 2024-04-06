package com.bank.core.config;

import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.IgniteClient;

import com.bank.core.proto.pain_008_001_10.DocumentOuterClass.Document;
import com.bank.core.proto.pain_008_001_10.PaymentServiceGrpc.PaymentServiceImplBase;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class PaymentServerImpl extends PaymentServiceImplBase {
	
	private final IgniteClient ignite;
	
	public PaymentServerImpl(IgniteClient client) {
		this.ignite=client;
	}
	@Override
	public void createPayment(Document request, StreamObserver<Document> responseObserver) {
		// TODO Auto-generated method stub
		log.info("Creating payment with payload "+request.getCstmrDrctDbtInitn().getGrpHdr().getMsgId());
		
		ClientCache<String, Document> cache=ignite.getOrCreateCache("payment");
		cache.put(request.getCstmrDrctDbtInitn().getGrpHdr().getMsgId(), request);
		responseObserver.onNext(cache.get(request.getCstmrDrctDbtInitn().getGrpHdr().getMsgId()));
		responseObserver.onCompleted();
	}
}
