package ch.usi.star.bear.myualberta;

import java.io.File;
import java.util.List;

import ch.usi.star.bear.BearEngine;
import ch.usi.star.bear.apache.ApacheLoader;
import ch.usi.star.bear.model.Model;

public class Example {

	public static void main(String[] args) {

		File logFile = new File("res/output.log");
		ApacheLoader apacheLoader = new ApacheLoader(logFile);
		BearEngine bearEngine = new BearEngine("ch.usi.star.bear.myualberta", "ch.usi.star.bear");
		bearEngine.setStemmer(new Stemmer());

		try {
			bearEngine.infers(apacheLoader);
			List<Model> models = bearEngine.exportModels();
			System.out.println(bearEngine.analyze("{}", "P =?[(F home)]", models, false));
			//visualization.BearVisualizer(model)
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
