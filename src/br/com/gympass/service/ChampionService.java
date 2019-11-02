package br.com.gympass.service;

import java.util.List;

import br.com.gympass.model.RaceLap;
import br.com.gympass.util.ConverterUtil;

public class ChampionService {

	private List<RaceLap> listRacers;

	public ChampionService(List<RaceLap> listRacers) {
		this.listRacers = listRacers;
	}

	public RaceLap getChampion() {
		RaceLap champion = null;
		int countTime = Integer.MAX_VALUE;
		for (RaceLap lap : this.listRacers) {
			if ((ConverterUtil.convertStringToInt(lap.getTime()) < countTime)
					&& (lap.getNumberLap() == lastLap(this.listRacers))) {
				countTime = ConverterUtil.convertStringToInt(lap.getTime());
				champion = lap;
			}
		}
		return champion;
	}

	private int lastLap(List<RaceLap> listRacers) {
		int numberLastLap = 0;
		for (RaceLap lap : listRacers) {
			if (lap.getNumberLap() > numberLastLap) {
				numberLastLap = lap.getNumberLap();
			}
		}
		return numberLastLap;
	}

	public void print() {
		System.out.println("***************** CHAMPION *************************");
		RaceLap champion = getChampion();
		System.out.println(String.format("ID: %s \nName: %s \nTime: %s \nAvarage Lap Speed: %s", champion.getIdRacer(),
				champion.getRacer(), champion.getTime(), champion.getAvarageLapSpeed()));
		System.out.println("***************************************************\n");
	}

}
