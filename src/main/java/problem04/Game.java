package problem04;

import java.io.Serializable;

public class Game implements Serializable{
	private int challenge;
	private int retry;
	private int time;
	
	
	public Game() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Game(int challenge, int retry, int time) {
		super();
		this.challenge = challenge;
		this.retry = retry;
		this.time = time;
	}


	public int getChallenge() {
		return challenge;
	}
	public void setChallenge(int challenge) {
		this.challenge = challenge;
	}
	public int getRetry() {
		return retry;
	}
	public void setRetry(int retry) {
		this.retry = retry;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	
}
