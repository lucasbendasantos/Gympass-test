package br.com.gympass.model;

public class RaceLap {

	private String idRacer;
	private String time;
	private String racer;
	private int numberLap;
	private String lapTime;
	private double avarageLapSpeed;
	
	public String getIdRacer() {
		return idRacer;
	}

	public void setIdRacer(String idRacer) {
		this.idRacer = idRacer;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRacer() {
		return racer;
	}

	public void setRacer(String racer) {
		this.racer = racer;
	}

	public int getNumberLap() {
		return numberLap;
	}

	public void setNumberLap(int lap) {
		this.numberLap = lap;
	}

	public String getLapTime() {
		return lapTime;
	}

	public void setLapTime(String lapTime) {
		this.lapTime = lapTime;
	}

	public double getAvarageLapSpeed() {
		return avarageLapSpeed;
	}

	public void setAvarageLapSpeed(double avarageLapSpeed) {
		this.avarageLapSpeed = avarageLapSpeed;
	}

	@Override
	public String toString() {
		return String.format(
				"{\"time\":\"%s\",\"racer\":\"%s\",\"lap\":\"%s\",\"lapTime\":\"%s\",\"avarageLapSpeed\":\"%s\"}",
				time, racer, numberLap, lapTime, avarageLapSpeed);
	}

}
