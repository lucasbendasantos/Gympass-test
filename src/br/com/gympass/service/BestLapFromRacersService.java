package br.com.gympass.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import br.com.gympass.model.RaceLap;
import br.com.gympass.util.ConverterUtil;

public class BestLapFromRacersService {

	private Map<String, List<RaceLap>> groupRacers;

	public BestLapFromRacersService(Map<String, List<RaceLap>> groupRacers) {
		this.groupRacers = groupRacers;
	}

	public List<RaceLap> bestLapFromRacers() {
		List<RaceLap> result = new ArrayList<RaceLap>();
		Map<String, List<RaceLap>> listPilots = this.groupRacers;
		Object[] racers = listPilots.keySet().toArray();

		for (int i = 0; i < racers.length; i++) {
			String racer = (String) racers[i];
			List<RaceLap> laps = listPilots.get(racer);
			result.add(bestLapFromRacer(laps));
		}
		return result;
	}

	private RaceLap bestLapFromRacer(List<RaceLap> laps) {
		RaceLap raceLap = new RaceLap();
		int bestLap = Integer.MAX_VALUE;
		for (int i = 0; i < laps.size(); i++) {
			int lapTime = ConverterUtil.convertStringToInt(laps.get(i).getLapTime());
			if (lapTime < bestLap) {
				bestLap = lapTime;
				raceLap = laps.get(i);
			}
		}
		return raceLap;
	}

	public void print() {
		System.out.println(
				"***************** Best Lap From Racers *****************************************************");
		System.out.println("Id\t\tName\t\t\tlap\t\tTime\t\t\tAvarage Lap Speed");
		for (RaceLap raceLap : bestLapFromRacers()) {
			System.out.println(String.format("%s\t\t%s\t\t%s\t\t%s\t\t%s", raceLap.getIdRacer(), raceLap.getRacer(),
					raceLap.getNumberLap(), raceLap.getTime(), raceLap.getAvarageLapSpeed()));
		}
		System.out.println(
				"********************************************************************************************\n");
	}

}
