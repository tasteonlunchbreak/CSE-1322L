package Assignment6;
import java.util.ArrayList;

public class Queries {
    public static int higherEduAtDiffUni(ArrayList<GraduateInfo> list) {
        int count = 0;

            for (GraduateInfo g : list) {
                if (g.target_university.equals("kennesaw state university") &&
                    !g.highest_edu_university.equals("kennesaw state university")) {
                    count++;
            }
        } return count;
    }
    public static int[] highestEducationLvl(ArrayList<GraduateInfo> list) {
        int[] result = new int[5];

        for (GraduateInfo g : list) {
            String level = g.highest_edu_level.toLowerCase();

            if (level.equals("certificate")) result[0]++;
            else if (level.equals("associates")) result[1]++;
            else if (level.equals("bachelors")) result[2]++;
            else if (level.equals("masters")) result[3]++;
            else if (level.equals("doctorate")) result[4]++;
        }
        return result;
    }
    public static int[] lastYearAtKSU(ArrayList<GraduateInfo> list) {
        int[] result = new int[5];

        for (GraduateInfo g : list) {
            if (!g.target_university.equals("kennesaw state university"))
                continue;
            int year = g.target_edu_year;

            if (year < 2005) result[0]++;
            else if (year <= 2009) result[1]++;
            else if (year <= 2014) result[2]++;
            else if (year <= 2019) result[3]++;
            else result[4]++;
        }
        return result;
    }
    public static ArrayList<String> topFiveIndustries(ArrayList<GraduateInfo> list) {
        ArrayList<String> industries = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        for (GraduateInfo g : list) {
            String industry = g.current_employer_industry;

            int index = industries.indexOf(industry);

            if (index == -1) {
                industries.add(industry);
                counts.add(1);
            } else {
                counts.set(index, counts.get(index) + 1);
            }
        }
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int max = -1;
            int maxIndex = -1;
            
            for (int j = 0; j < counts.size(); j++) {
                if (counts.get(j) > max) {
                    max = counts.get(j);
                    maxIndex = j;
                }
            }
            result.add(industries.get(maxIndex) + ": " + max);
            counts.set((maxIndex), -1);
        }
        return result;
    }
    
}
