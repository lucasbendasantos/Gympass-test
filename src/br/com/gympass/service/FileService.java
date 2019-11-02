package br.com.gympass.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.com.gympass.model.RaceLap;
import br.com.gympass.repository.FileRepository;

public class FileService {

	private FileRepository fileRepository;

	public FileService() {
		this.fileRepository = new FileRepository();
	}

	public List<String> getMetrics(String file) throws IOException {
		if (file.isEmpty()) {
			throw new IOException("File is empty");
		}
		List<String> list = fileRepository.readFile(file);
		return list;
	}

	public Map<String, List<RaceLap>> groupPilots(List<RaceLap> list) {
		return list.stream().collect(Collectors.groupingBy(RaceLap::getIdRacer));
	}

	public List<RaceLap> getList(String file) throws IOException {

		List<String> resultFile = getMetrics(file);

		List<RaceLap> listRaces = new ArrayList<RaceLap>();
		for (int i = 1; i < resultFile.size(); i++) {
			listRaces.add(convertLineToRece(resultFile.get(i)));
		}
		return listRaces;
	}

	private RaceLap convertLineToRece(String line) {
		String[] arrayLine = line.split("\\s{2,}");

		RaceLap raceLap = new RaceLap();
		raceLap.setTime(arrayLine[0]);
		raceLap.setIdRacer(arrayLine[1].substring(0, 3));
		raceLap.setRacer(arrayLine[1].substring(6, arrayLine[1].length()));
		raceLap.setNumberLap(Integer.parseInt(arrayLine[2]));
		raceLap.setLapTime(arrayLine[3]);
		raceLap.setAvarageLapSpeed(Double.parseDouble(arrayLine[4].replaceAll(",", ".")));

		return raceLap;
	}

}
