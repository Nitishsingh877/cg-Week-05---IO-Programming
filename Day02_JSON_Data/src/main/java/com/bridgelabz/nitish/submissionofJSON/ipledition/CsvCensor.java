package com.bridgelabz.nitish.submissionofJSON.ipledition;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class CsvCensor {



    public static void censorCsvContent(String csvPath,String modifiedCsvPath)throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new FileReader(csvPath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(modifiedCsvPath));

        String headLine = bufferedReader.readLine();
        bufferedWriter.write(headLine);
        bufferedWriter.newLine();
        String[] headers = headLine.split(",");
        int columnsCount = headers.length;
        String line;

        while((line = bufferedReader.readLine()) != null){
            String[] fields = line.split(",");
            //0-> match_id 1-> team1 2-> team2 3-> score-team1 4-> score-team2 5-> winner 6-> player-of-match
            if(fields.length == columnsCount) {
                String matchId = fields[0].strip();
                String team1 = fields[1].strip();
                String team2 = fields[2].strip();
                String score1 = fields[3].strip();
                String score2 = fields[4].strip();
                String winner = fields[5].strip();
                String player = fields[6].strip();

                StringBuilder sb = new StringBuilder();
                sb.append(matchId+",");
                sb.append(censorTeam(team1)+",");
                sb.append(censorTeam(team2)+",");
                sb.append(score1+",");
                sb.append(score2+",");
                sb.append(censorTeam(winner)+",");
                sb.append("REDACTED");
                bufferedWriter.write(sb.toString());
                bufferedWriter.newLine();

            }
        }
        bufferedWriter.close();
        bufferedReader.close();
    }
    private static String censorTeam(String team){
        String[] words = team.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(words[0]+" ");
        for(int i = 1;i<words.length;i++){
            String match = "*".repeat(words[i].length());
            String censored = words[i].replaceAll("(?i)\\b\\w+\\b",match);

            sb.append(censored);
            if(i != words.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
