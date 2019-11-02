package br.com.gympass.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.gympass.model.RaceLap;

public class AvarageLapSpeedRacersService {
	
	private Map<String, List<RaceLap>> groupRacers;
	
	public AvarageLapSpeedRacersService(Map<String, List<RaceLap>> groupRacers) {
		this.groupRacers = groupRacers;
	}
	
	public List<Map<String, String>> avarageLapSpeedFromRacers() {
		List<Map<String, String>> result = new ArrayList<>();
		Map<String, List<RaceLap>> listRacers = this.groupRacers;
		Object[] racers = listRacers.keySet().toArray();

		for (int i = 0; i < racers.length; i++) {
			String race = (String) racers[i];
			List<RaceLap> laps = listRacers.get(race);
			result.add(avarageLapSpeedRacer(laps));
		}
		return result;
	}
	
	private Map<String, String> avarageLapSpeedRacer(List<RaceLap> laps) {
		int count = 0;
		Double total = 0.0;
		for (int i = 0; i < laps.size(); i++) {
			count++;
			total += laps.get(i).getAvarageLapSpeed();
		}
		HashMap<String, String> result = new HashMap<String, String>();
		DecimalFormat format = new DecimalFormat("0.00");
		result.put(laps.get(1).getRacer(), format.format(total / count));
		return result;
	}
	
	public void print() {
		System.out.println("***************** Avarage Lap Speed Racers ***********");
		List<Map<String, String>> list = avarageLapSpeedFromRacers();
		System.out.println("Racer\t\t\tAvarage");
		for (Map<String, String> avarage : list) {
			Set<String> key = avarage.keySet();
			System.out.println(String.format("%s\t\t%s", key.toArray()[0], avarage.get(key.toArray()[0])));
		}
		System.out.println("***************************************************\n");
	}

}
