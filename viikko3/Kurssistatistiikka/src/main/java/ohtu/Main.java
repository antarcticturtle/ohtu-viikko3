package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashSet;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // ÄLÄ laita githubiin omaa opiskelijanumeroasi
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/courses/students/"+studentNr+"/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

//        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        
        
        
        System.out.println("Opiskelijanumero " + studentNr);
        System.out.println("");
        printByCourse(subs);

    }
    
    public static void printByCourse(Submission[] subs){
        HashSet<String> courses = new HashSet<>();
        for(Submission sub : subs){
            if(!courses.contains(sub.getCourse())){
                printCourse(sub.getCourse(), subs);
            }
            courses.add(sub.getCourse());
        }
        
    }
    
    public static void printCourse(String course, Submission[] subs){
        int ex = 0;
        int hours = 0;
        for(Submission sub : subs){
            if(sub.getCourse().equals(course)){
                ex += sub.getExercises().length;
                hours += sub.getHours();
                System.out.println(sub);
            }
        }
        
        System.out.println("\nYhteensä " + ex + " tehtävää, " + hours + " tuntia.\n");
    } 
}