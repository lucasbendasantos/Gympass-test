package br.com.gympass.service;

import java.util.List;

import br.com.gympass.model.RaceLap;
import br.com.gympass.util.ConverterUtil;

public class BestLapFromRaceService {

	private List<RaceLap> list;

	public BestLapFromRaceService(List<RaceLap> list) {
		this.list = list;
	}

	public RaceLap bestLapFromRace() {
		RaceLap raceLap = new RaceLap();
		int bestLap = Integer.MAX_VALUE;
		for (int i = 0; i < this.list.size(); i++) {
			if (ConverterUtil.convertStringToInt(this.list.get(i).getLapTime()) < bestLap) {
				bestLap = ConverterUtil.convertStringToInt(this.list.get(i).getLapTime());
				raceLap = this.list.get(i);
			}
		}
		return raceLap;
	}

	public void print() {
		System.out.println("***************** Best Lap From Race ***********");
		RaceLap bestLapFromRace = bestLapFromRace();
		System.out.println(String.format("ID: %s \nName: %s \nTime: %s \nLap: %s \nlapTime: %s\nAvarage Lap Speed: %s",
				bestLapFromRace.getIdRacer(), bestLapFromRace.getRacer(), bestLapFromRace.getTime(),
				bestLapFromRace.getNumberLap(), bestLapFromRace.getLapTime(), bestLapFromRace.getAvarageLapSpeed()));
		System.out.println("***************************************************\n");

	}

}
