//class for a TET scale
public class scale
{
  int numnotes;
  double semitone;
  double[] notes;
  double accuracyScore = 0;

  //constructor
  public scale(double n)
  {
      this.numnotes = (int) n;
      this.semitone = Math.pow(2, 1/n);
      //System.out.println(semitone);
      //System.out.print(Math.pow(semitone, numnotes));
      generate();
  }
  //fills array with notes
  public void generate()
  {
      notes = new double[numnotes];
      for(int i = 0; i < numnotes; i++)
      {
        notes[i] = 440 * Math.pow(semitone, i);
      }
  }
  //Prints out each note and its frequency
  public void getNotes()
  {
    for(int x = 0; x < numnotes; x++)
    {
        System.out.println("Note "+ x + ": " + notes[x]);
    }
  }
  public void evaluate()
  {
    //theoretical ratios based on note A as 440 hz
    double tMinorThird = 440 * 6/5;    //Weight of 1/1.9 = 0.526...
    double tMajorThird = 440 * 5/4;    //Weight of 1/2.2 = 0.454...
    double tPerfectFourth = 440 * 4/3; //Weight of 1/1.6 = 0.714...
    double tPerfectFifth = 440 * 3/2;  //Weight of 1/0.5 = 2
    double tMajorSixth = 440 * 3/5;    //Weight of 1/0.8 = 1.25

    //initialize difference between theoretical and actual
    double minorThirdDiff = 1000;
    double majorThirdDiff = 1000;
    double perfectFourthDiff = 1000;
    double perfectFifthDiff = 1000;
    double majorSixthDiff = 1000;

    //determines the difference between each theoretical ratio and the closet actual note
    for(int x = 0; x < numnotes; x++)
    {
        double temp = notes[x];
        if(Math.abs(tMinorThird - temp) < minorThirdDiff)
        {
          minorThirdDiff = Math.abs(tMinorThird - temp);
        }
        if(Math.abs(tMajorThird - temp) < majorThirdDiff)
        {
          majorThirdDiff = Math.abs(tMajorThird - temp);
        }
        if(Math.abs(tPerfectFourth - temp) < perfectFourthDiff)
        {
          perfectFourthDiff = Math.abs(tPerfectFourth - temp);
        }
        if(Math.abs(tPerfectFifth - temp) < perfectFifthDiff)
        {
          perfectFifthDiff =  Math.abs(tPerfectFifth - temp);
        }
        if(Math.abs(tMajorSixth - temp) < majorSixthDiff)
        {
          majorSixthDiff =  tMajorSixth - temp;
        }
    }
    //calcualate accuracyScore
    accuracyScore += ((1/minorThirdDiff) * (1/1.9));
    accuracyScore += ((1/majorThirdDiff) * (1/2.2));
    accuracyScore += ((1/perfectFourthDiff) * (1/1.6));
    accuracyScore += ((1/perfectFifthDiff) * (1/0.5));
    accuracyScore += ((1/majorSixthDiff) * (1/0.8));

    //print score
    System.out.println(numnotes + " Note Scale: " +accuracyScore);
  }
}