package org.tony.actor;

import akka.actor.AbstractActor;

public class AngryFoalActor extends AbstractActor {

	@Override
	public Receive createReceive() {
		return receiveBuilder().match(String.class, message -> {
			System.out.println("Received String message: " + message);
		}).match(Integer.class, message -> {
			System.out.println("Received String message: " + message);
			getSender().tell((int) message + 20, getSelf());
		}).matchAny(o -> System.out.println("received unknown message")).build();
	}

}