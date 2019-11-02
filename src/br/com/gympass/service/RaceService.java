package br.com.gympass.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import br.com.gympass.model.RaceLap;

public class RaceService {

	private FileService fileService;
	private ChampionService championService;
	private BestLapFromRacersService bestLapFromRacersService;
	private BestLapFromRaceService bestLapFromRaceService;
	private AvarageLapSpeedRacersService avarageLapSpeedRacersService;
	private DifferenceChampionService differenceChampionService;

	private List<RaceLap> list;
	private Map<String, List<RaceLap>> groupRacers;
	
	public RaceService(String file) throws IOException {
		this.fileService = new FileService();
		this.list = fileService.getList(file);
		this.groupRacers = fileService.groupPilots(this.list);
		this.championService = new ChampionService(list);
	}
	
	public void championRace() {
		championService.print();
	}
	
	public void bestLapRacers() {
		bestLapFromRacersService = new BestLapFromRacersService(groupRacers);
		bestLapFromRacersService.print();
	}
	
	public void bestLapRace() {
		bestLapFromRaceService = new BestLapFromRaceService(list);
		bestLapFromRaceService.print();
	}
	
	public void avarageLapSpeed() {
		avarageLapSpeedRacersService = new AvarageLapSpeedRacersService(groupRacers);
		avarageLapSpeedRacersService.print();
	}
	
	public void championDifference() throws ParseException {
		differenceChampionService = new DifferenceChampionService(championService.getChampion(), groupRacers);
		differenceChampionService.print();
	}
	
	public void metricsRace() throws ParseException {
		championRace();
		bestLapRacers();
		bestLapRace();
		avarageLapSpeed();
		championDifference();
	}
	
	

	
}
