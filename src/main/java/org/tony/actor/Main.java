package org.tony.actor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import akka.actor.ActorRef;
import scala.util.Random;

public class Main {

	public static void main(String[] args) {
		ActorSystemTools.start();
		ActorRef angryFoal = ActorSystemTools.actorOf(AngryFoalActor.class);
		ActorRef lazyFoal = ActorSystemTools.actorOf(LazyFoalActor.class);
		ExecutorService es= Executors.newFixedThreadPool(4);
		es.execute(()->{
			angryFoal.tell(new Random().nextInt(10000), lazyFoal);
		});
		es.execute(()->{
			lazyFoal.tell("hello! I am  lazyFoal!", angryFoal);
		});
		//ActorSystemTools.shutdown();
	}
}
