package Crear_Proceso_desde_Java;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

	
	
	public static void main(String[] args) {
		
		ProcessBuilder processBuilder = new ProcessBuilder();
		
		processBuilder.command("cmd.exe", "/c", "ping -n 3 google.com");
		
		try{
			Process process = processBuilder.start();

			// blocked :(
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        
            int exitCode = process.waitFor();
            System.out.println("\nSalimos del proceso con el codigo de error : " + exitCode);
		} catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		

	}

}
