//Egemen BALLI 4 Dec 2023
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader implements Service{
        static String st = "";
        @Override
        public String readDataFile(String filePath) {
                JSONParser jsonParser = new JSONParser();

                try (FileReader reader = new FileReader("employees.json"))
                {
                        Object obj = jsonParser.parse(reader);

                        JSONArray employeeList = (JSONArray) obj;
                        st += employeeList + "\n";

                        employeeList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );

                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                } catch (IOException e) {
                        e.printStackTrace();
                } catch (ParseException e) {
                        e.printStackTrace();
                }

                return st;
        }

        private static void parseEmployeeObject(JSONObject employee)
        {
                JSONObject employeeObject = (JSONObject) employee.get("employee");
                String firstName = (String) employeeObject.get("firstName");
                st += firstName + "\n";

                String lastName = (String) employeeObject.get("lastName");
                st += lastName + "\n";

                String website = (String) employeeObject.get("website");
                st += website + "\n";
        }
}
