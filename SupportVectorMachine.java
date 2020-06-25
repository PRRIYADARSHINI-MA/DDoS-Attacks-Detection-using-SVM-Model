/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firecol;

/**
 *
 * @author admin
 */
import java.io.File;
import javax.swing.JFileChooser;
import static jdk.nashorn.internal.objects.NativeRegExp.source;
import weka.classifiers.Classifier;
import weka.classifiers.functions.SMOreg;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.functions.supportVector.Kernel;
import weka.classifiers.functions.supportVector.NormalizedPolyKernel;
import weka.classifiers.functions.supportVector.PolyKernel;
import weka.classifiers.functions.supportVector.RBFKernel;
import weka.classifiers.functions.supportVector.SMOset;
import weka.core.Instance;


public class SupportVectorMachine {
	public static void main(String[] args) throws Exception {
		DataSource source = new DataSource("C:\\Users\\Prriydarshini MA\\Desktop\\honeypot\\ddos virus.csv");
		Instances trainedDataset = source.getDataSet();	
		//set class index to the last attribute
		trainedDataset.setClassIndex(trainedDataset.numAttributes()-1);

		//build model
		SMOreg svm = new SMOreg();
		svm.buildClassifier(trainedDataset);
		//output model
svm.getCapabilities();
svm.getKernel();
svm.listOptions();
svm.getRegOptimizer();
svm.cTipText();
svm.getC();
svm.getOptions();
int[] options={1,2,3};
options[0]= 0;
options[1]=1;
options[2]=2;
		//load new dataset
                					 JFileChooser chooser = new JFileChooser();

		                  File field = chooser.getSelectedFile();
                                  			            File curFile = chooser.getSelectedFile();
String fname=null;
                                  			             fname=curFile.getName();


		Instances testDataset = source.getDataSet();	
		//set class index to the last attribute
		testDataset.setClassIndex(testDataset.numAttributes()-1);

		//loop through the new dataset and make predictions
		for (int i = 0; i < testDataset.numInstances(); i++) {
			//get class double value for current instance
			double actualValue = testDataset.instance(i).classValue();

			//get Instance object of current instance
			Instance newInst = testDataset.instance(i);
			//call classifyInstance, which returns a double value for the class
			double predSMO = svm.classifyInstance(newInst);

			System.out.println(actualValue+", "+predSMO);
                        
                        if(predSMO!=0)
                        {
                            System.out.println("No threats found");
                        }
                        else
                        {
                            System.out.println("Threat Found");
                        }
		}

		/*
		//load training dataset
		DataSource source = new DataSource("/home/likewise-open/ACADEMIC/csstnns/Desktop/iris.arff");
		Instances trainDataset = source.getDataSet();	
		//set class index to the last attribute
		trainDataset.setClassIndex(trainDataset.numAttributes()-1);
		//get number of classes
		int numClasses = trainDataset.numClasses();
		//print out class values in the training dataset
		for(int i = 0; i < numClasses; i++){
			//get class string value using the class index
			String classValue = trainDataset.classAttribute().value(i);
			System.out.println("Class Value "+i+" is " + classValue);
		}
		//create and build the classifier
		NaiveBayes nb = new NaiveBayes();
		predString = testDataset.classAttribute().value((int) predNB);
			System.out.println(actual+", "+predString);
		}
		 */
	}
}