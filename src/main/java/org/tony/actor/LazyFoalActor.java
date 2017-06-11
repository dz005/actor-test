package org.tony.actor;

import akka.actor.AbstractActor;

public class LazyFoalActor extends AbstractActor {

	@Override
	public Receive createReceive() {
		return receiveBuilder().matchAny(message -> System.out.println("Received String message: " + message)).build();
	}
}
