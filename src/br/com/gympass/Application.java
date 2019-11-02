package br.com.gympass;

import java.io.IOException;
import java.text.ParseException;

import javax.swing.JFileChooser;

import br.com.gympass.service.RaceService;

public class Application {

	public static void main(String[] args) {
		try {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("Selecione o arquivo");
			int openDialog = fileChooser.showOpenDialog(null);
			String path = "./Race.txt";
			
			if (!(fileChooser.CANCEL_OPTION == openDialog || fileChooser.ERROR_OPTION == openDialog)) {
				path = fileChooser.getSelectedFile().getAbsolutePath();
			}
			RaceService raceService = new RaceService(path);
			raceService.metricsRace();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
