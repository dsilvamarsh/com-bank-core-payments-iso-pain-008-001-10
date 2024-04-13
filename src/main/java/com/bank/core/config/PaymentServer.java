package com.bank.core.config;

import java.io.IOException;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaymentServer {

	private Server server;
	// default port to start the server on
	int port = 8080;

	private void start() throws IOException {
		/*
		 * log.debug("Nettey Server starting to service Payments "); server =
		 * Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
		 * .addService(new PaymentServerImpl())
		 * 
		 * .build().start();
		 * 
		 * log.debug("Server Started on port : " + port);
		 * Runtime.getRuntime().addShutdownHook(new Thread() {
		 * 
		 * @Override public void run() {
		 * System.err.println("*** shutting down gRPC server since JVM is shutting down"
		 * ); log.debug("*** shutting down gRPC server since JVM is shutting down"); try
		 * { PaymentServer.this.stop(); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * System.err.println("*** server shut down"); } });
		 * 
		 */}

	/**
	 * @author dsilvamarsh
	 * @throws InterruptedException The method allows gracefull termination
	 */
	private void stop() throws InterruptedException {
		if (server != null) {
			server.shutdown().awaitTermination();
		}
	}

	/**
	 * Await termination on the main thread since the grpc library uses daemon
	 * threads.
	 */
	private void blockUntilShutdown() throws InterruptedException {
		if (server != null)
			server.awaitTermination();
	}

	/**
	 * Main launches the server from the command line.
	 * 
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		PaymentServer server = new PaymentServer();
		log.debug("Starting server in the main thread");
		server.start();

		server.blockUntilShutdown();
		log.debug("Blocking the main thread and waiting for the shutdown hook to be invoked");
	}

}
