package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Enviroment;

public class JSONUtility {

	public static Enviroment readJson(Env env) {
		Gson gson = new Gson();
		File jsonFile = new File(System.getProperty("user.dir") + "//config//config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		Config config = gson.fromJson(fileReader, Config.class);
		return config.getEnviroments().get(env.name());

	}
}
