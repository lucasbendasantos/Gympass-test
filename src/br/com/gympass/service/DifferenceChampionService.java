package br.com.gympass.service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.gympass.model.RaceLap;
import br.com.gympass.util.ConverterUtil;

public class DifferenceChampionService {
	
	private RaceLap champion;
	private Map<String, List<RaceLap>> groupRacers;
	
	public DifferenceChampionService(RaceLap champion, Map<String, List<RaceLap>> groupRacers) {
		this.champion = champion;
		this.groupRacers = groupRacers;
	}
	
	
	public Map<String, String> differenceChampion( ) throws ParseException {
		Map<String, String> result = new HashMap<String, String>();
		Map<String, List<RaceLap>> listRacers = this.groupRacers;
		Object[] racers = listRacers.keySet().toArray();
		Double championTime = ConverterUtil.convertStringToDouble(this.champion.getLapTime());
		DecimalFormat format = new DecimalFormat("0.00");
		for (int i = 0; i < racers.length; i++) {
			if (!(racers[i].equals(champion.getIdRacer()))) {
				RaceLap lap = lastLapOfRacer(listRacers.get(racers[i]));
				Double total = ConverterUtil.convertStringToDouble(lap.getLapTime()) - championTime;
				result.put(lap.getRacer(), format.format(total));
			}
		}
		return result;
	}

	private RaceLap lastLapOfRacer(List<RaceLap> laps) {
		return laps.get(laps.size() - 1);
	}
	
	public void print() throws ParseException {
		System.out.println("***************** Champion Difference ***********");
		Map<String, String> diffObject = differenceChampion();
		System.out.println("Racer\t\t\tTime(secconds)");
		Object[] keys = diffObject.keySet().toArray();
		for (Object key : keys) {
			System.out.println(String.format("%s\t\t%s", key, diffObject.get(key)));
		}

	}

}
