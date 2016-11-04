package core;

import java.io.File;
import java.net.URISyntaxException;
import java.security.CodeSource;


public class Locations {
	
	public static final String REPO_URL = "git://github.com/Poxleit/StudymeisterC.git";
	
	public static String getLocation(){
		CodeSource codeSource = Launcher.class.getProtectionDomain().getCodeSource();
		File launcher = null;
		try {
			launcher = new File(codeSource.getLocation().toURI().getPath());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return launcher.getParentFile().getPath();
	}
}
