/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compiler;

import java.util.regex.Pattern;

/**
 *
 * @author Baron
 */

public class compilerFunction {
    String question = "";
    String outcome;
    String sample;
    int sampleNumber;
    int questNumber;
    static int num = 0;
    
    public compilerFunction(int questNo, String sample){
        num++;
        this.questNumber = questNo;
        this.sampleNumber = num;
        this.sample = sample;
    }
    public int getQuestionNum()
    {
        return this.questNumber;
    }
    public int getSampleNum()
    {
        return this.sampleNumber;
    }
    public void setSample(int sampleNum){
        this.sampleNumber = sampleNum;
    }
    public String getSample(){
        return this.sample;
    }
    public void setSample(String sample){
        this.sample = sample;
    }
    public void question(){
        if(this.questNumber == 1){
            this.question = "(aba|bab){1}(a|b)*(bab){1}(a|b)*(a|b|ab|ba){1}(a|b|aa)*";
        } else if (this.questNumber == 2){
            this.question = "((101|111|101){1}|(1|0|11){1})(1|0|01)*(111|000|101){1}(1|0)*";
        }
    }
    public String answer(){
        String testSample = this.sample;
        if(testSample.contains(" ")){
            boolean b = Pattern.matches(this.question, testSample);
            if(b) {
              this.outcome = "VALID";
            } else {
              this.outcome = "INVALID";
            }
        } else {
            boolean b = Pattern.matches(this.question, testSample);
            if(b) {
              this.outcome = "VALID";
            } else {
              this.outcome = "INVALID";
            }
        }   
        return this.outcome;
    }
    
    @Override
    public String toString(){
        return this.outcome + "\n"; 
    }
}
