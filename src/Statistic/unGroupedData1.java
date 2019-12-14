
package Statistic;

//import javafx.scene.chart.PieChart.Data;



public final class unGroupedData1 {
   private double MomentAboutMean;
   private double MomentAboutOrigin;
   private double MomentAboutR;
   private double sumData;// 
   private double sumFreq = 0;// summation the possible frequancy
   private double sumDataFreq=0;//summation data*frequancy
   private Object array[][];//
   private String title[];
   private  double mean;
   private double data[];
   private double frequncy[];
   private double relativeFreuancy[];
   private double commulativeFrequancy[];
   private double percent[];
   private double GeometricMean;
   private double HarmonicMean;
   private double Mode ;
   private double Range;
   private double MeanDeviation;//
   private double MeanAbsolute;//
  private double StandardDeviation;
  private double multiplicationData;
    private  double Median;
   private double QuadraticMean;
   private double Variance;
  
   private double commulativeRelativefreqancy[];
   public  unGroupedData1(){
    
    
    }
    /*public unGroupedData1(SetOfData b) throws Exception{
    if(b.dataOnly==null)
    {
    this.StandardDeviation(b.dataWithfreq, b.freq);
   this.setData(b.dataWithfreq);
   this.setFrequncy(b.freq);
    this.mean(b.dataWithfreq, b.freq);
   this.MeanFreqRelative(b.dataWithfreq, b.freq);
    this.Median(b.dataWithfreq, b.freq);
   this.Mode(b.dataWithfreq, b.freq);
    this.QuadraticMean(b.dataWithfreq, b.freq);
   this.comuliveFrequancy(b.freq);
    this.Max(b.dataWithfreq);
    this.Min(b.dataWithfreq);
    this.RelativeFrequancy(b.dataWithfreq);
    this.comuliveFrequancy(b.dataWithfreq);
    this.multiply(b.dataWithfreq, b.freq);
    this.summationData(b.dataWithfreq);
    this.summationInverseData(b.dataWithfreq);
    this.summationSquireData(b.dataWithfreq);
    this.percentFrequancy(b.freq);
    this.Variance(b.dataWithfreq, b.freq);
   
    
    
    }else{
    
    this.setData(b.dataOnly);
        this.GeometricMean(b.dataOnly);
        this.HarmonicMean(b.dataOnly);
        this.Max(b.dataOnly);
        this.Median(b.dataOnly);
        this.Min(b.dataOnly);
        this.Mode(b.dataOnly);
        this.QuadraticMean(b.dataOnly);
        this.mean(b.dataOnly);
        this.StandardDeviation(b.dataOnly);
        this.summationData(b.dataOnly);
        this.MeanDeviation(b.dataOnly);
        this.Variance(b.dataOnly);
    
    
    }
    
    }*/
   public  unGroupedData1(double data[],double freq[]) throws Exception
    {
    this.StandardDeviation(data, freq);
   this.setData(data);
   this.setFrequncy(freq);
    this.mean(data, freq);
   this.MeanFreqRelative(data, freq);
    this.Median(data, freq);
   this.Mode(data, freq);
    this.QuadraticMean(data, freq);
   this.comuliveFrequancy(freq);
    this.Max(data);
    this.Min(data);
    this.RelativeFrequancy(freq);
    this.comuliveFrequancy(frequncy);
    this.multiply(data, freq);
    this.summationData(data);
    this.summationInverseData(data);
    this.summationSquireData(data);
    this.percentFrequancy(freq);
    this.Variance(data, freq);
   
  
    
    }
   /* unGroupedData1(double data[]) throws Exception
    {
        this.setData(data);
        //this.GeometricMean(data);
        //this.HarmonicMean(data);
        this.Max(data);
        this.Median(data);
        this.Min(data);
        this.Mode(data);
       // this.QuadraticMean(data);
        this.mean(data);
        this.StandardDeviation(data);
        this.summationData(data);
        this.MeanDeviation(data);
        this.Variance(data);
    
    }*/
    //--------------------------------------------------------------------------------------------------------------------------------------
    public double Max(double data[])
    { 
        double max = 0;
        for(double i:data)
            {
                if(max<i)
                    max=i;
            }
    return max;
    }
   //----------------------------------------------------------------------------------------------------------------------------------------------------
    public double Min(double data[])
    { 
        double min = 0;
                for(double i:data)
                    {
                        if(min>i)
                             min=i;
                    }
    return min;
    }
    //---------------------------------------------------------------------------------------------------------------------------------------------------------
    public void mean(double Data[],double Frequancy[])throws Exception
    {
       this.sumDataFreq=0;
        if(Frequancy.length==Data.length)
                {
                  for(int i=0;i<Data.length;i++)
                      {
                          
                          this.sumDataFreq=this.sumDataFreq + (Data[i]*Frequancy[i]);
                      }
                
                 this.sumFreq=this.summationData(Frequancy);
                
                    
                    
                }
        else
                {
                        
                throw new Exception("you are entered wrong data!!");
                
                }    
         
    this.setMean((this.sumDataFreq/this.sumFreq));
   
    }
    //------------------------------------------------------------------------------
    public double Range(double Data[])
    {
    
    this.setRange(this.Max(data)-this.Min(data));
    return this.getRange();
    }
    //------------------------------------------------------------------------------
public double mean(double data[])throws Exception
        
{  setSumData(0);
  if(!this.DataIsEmpty(data))
         for(double i:data)
               {
                   setSumData(getSumData() + i);
               }
  else;
     //  throw new Exception("data is Empty");
  this.setMean(getSumData()/(double)data.length);
  
return this.getMean();

}
//---------------------------------------------------------------------------------------------------------------
public double mean(int NumberOfProbablity,double probablity){
   this.setMean((NumberOfProbablity*probablity));

return this.getMean();}
//------------------------------------------------------------------------------------------------------------------
public double variance(int NumberOfProbablity,double probablity){
    double Q=(1-probablity);
    this.setVariance((NumberOfProbablity*Q*probablity));

return this.getVariance();}
//---------------------------------------------------------------------------------------------------------------
public double StandardDeviation(int NumberOfProbablity,double probablity){
    this.SetStandardDeviation(Math.sqrt(this.variance(NumberOfProbablity, probablity)));
this.getStandardDeviation();
return this.getStandardDeviation();}
//---------------------------------------------------------------------------------------------------------------
   public double[] insertionSort(double array[])
   { 
       double a;
       int j;
       for(int i=1;i<array.length;i++)
           {
             j=i;
             while(j>0 && array[j]>array[j-1]){
             a=array[j];
             array[j]=array[j-1];
             array[j-1]=a;   
           
               j=j-1;
           }
          
       
       }
   
   return array;
   }
//----------------------------------------------------------------------------------------------------------------
public double Mode(double data[],double freq[]) throws Exception{
    if(data.length==freq.length){
        if(!this.DataIsEmpty(data)&&!this.DataIsEmpty(freq)){
    double da=this.Max(freq);
   int id=this. LinearSearch(freq, da);
    this.setMode(data[id]);
       
        }else{throw new Exception("Empty");}   }else{
    
    throw new Exception("diferrent length");
    }
return this.getMode();}
 //--------------------------------------------------------------------------------------------
   public int LinearSearch(double array[],double a){
       int c=0;
    for(int i=0;i<array.length;i++){
    if(array[i]==a){
     c=i;
     break;
    }
    
       }
    return c;
    }
   
    
//--------------------------------------------------------------------------------------------------------
    public  double Mode(double[] n) throws Exception
{
        this.insertionSort(n);
    
    double count2 = 0;
    double count1 = 0;
   double pupular1 =0;
    double popular2 =0;
if(!this.DataIsEmpty(data)){

    for (int i = 0; i < n.length; i++)
    {
            pupular1 = n[i];
            count1 = 0;    //see edit

        for (int j = i + 1; j < n.length; j++)
        {
            if (pupular1 == n[j]) count1++;
        }

        if (count1 > count2)
        {
                popular2 = pupular1;
                count2 = count1;
        }

        else if(count1 == count2)
        {
            popular2 = Math.min(popular2, pupular1);
        }
    }
this.setMode(popular2);
}
    return this.getMode();
}
//----------------------------------------------------------------------------------------------------------------
public double Median (double data[])throws Exception
{
    
    int N=data.length;
    double f=0,f1=0;
    this.insertionSort(data);
    if(N%2!=0)
        {
        this.setMedian(data[(N/2)]);
    
       }
    else if(N==0)
       {
    throw new Exception("Empty data");
    
        }
    else
    {
       f=  data[(N/2)+1];
       f1=data[(N/2)];
       
    this.setMedian((f+f1)/2);
    
    }

    
return this.getMedian();

}
//----------------------------------------------------------------------------------------------
public double Median (double data[],double freq[])throws Exception
{
    
      int N= (int) this.summationData(freq);
   double ar[];
       ar = new double[N];
    int c=0;
    
     if(!this.DataIsEmpty(data)&&!this.DataIsEmpty(freq)){
         if(data.length!=freq.length){
     
     throw new Exception("wrong lenght");
     }else{
    for (int i=0;i<data.length;i++){
    
       for(int j=0;j<freq[i];j++)
       {
        
           ar[c]=data[i];
       
       
       c++;
       }
    }
    this.Median(ar);}} 
    
    

    
return this.getMedian();

}
//-------------------------------------------------------------------------------------------
public double summationInverseData(double data[]) throws Exception
{double s=0;
if(!this.DataIsEmpty(data)) {
    for(int i=0;i<data.length;i++){
        double n =(1.0/data[i]);
        s=s+n;
    }
}
return s;
}
//----------------------------------------------------------------------------------
 public  double summationeData(double[] data, double[] freq, int rth) throws Exception {
     double u=0;int j=0;  
     if(data.length==freq.length){
     for(double i:data){
     
     u+=Math.pow(i, rth)*freq[j];
     j++;}}else{ throw new Exception("Different Size");}
      
return u;
    }
 //-----------------------------------------------------------------------------------
  public  double summationeDifferentDataAndMean(double[] data, double[] freq, int rth) throws Exception {
        double s=0;
        this.mean(data, freq);
if(!this.DataIsEmpty(data)) {
    for(int i=0;i<data.length;i++){
        double n =freq[i]*Math.pow((data[i]-this.getMean()), rth);
        
        s=s+n;
    }
}

return s;
    }
  //----------------------------------------------------------------------------------
  //-----------------------------------------------------------------------------------
  public  double summationeDifferentDataAndMean(double[] data, int rth) throws Exception {
        double s=0;
        this.mean(data);
if(!this.DataIsEmpty(data)) {
    for(int i=0;i<data.length;i++){
        double n =Math.pow((data[i]-this.getMean()), rth);
        
        s=s+n;
    }
}

return s;
    }
//------------------------------------------------------------------------------------
public double summationeDifferentDataAndOrign(double data[],double Orign,int power) throws Exception
{double s=0;
if(!this.DataIsEmpty(data)) {
    for(int i=0;i<data.length;i++){
        double n =Math.pow((data[i]-Orign), power);
        s=s+n;
    }
}
return s;
}
//------------------------------------------------------------------------------------
public double summationeDifferentDataAndOrign(double data[],double freq[],double Orign,int power) throws Exception
{double s=0;
if(!this.DataIsEmpty(data)) {
    for(int i=0;i<data.length;i++){
        double n =freq[i]*Math.pow((data[i]-Orign), power);
        s=s+n;
    }
}
return s;
}
//------------------------------------------------------------------------------------
public double summationeData(double data[],int power) throws Exception
{double s=0;
if(!this.DataIsEmpty(data)) {
    for(int i=0;i<data.length;i++){
        double n =Math.pow(data[i], power);
        s=s+n;
    }
}
return s;
}
//------------------------------------------------------------------------------------
public double summationSquireData(double data[]) throws Exception
{double s=0;
if(!this.DataIsEmpty(data)) {
    for(int i=0;i<data.length;i++){
        double n = data[i]*data[i];
        s=s+n;
    }
}
return s;
}
//----------------------------------------------------------------------------------------------------------------
public double GeometricMean(double data[]) throws Exception{
   if(!this.DataIsEmpty(data)){
    this.setSumData(this.summationSquireData(data));
    this.setGeometricMean(Math.sqrt((this.getSumData()/(double)data.length)));
   }

return this.getGeometricMean();
}
//-----------------------------------------------------------------------------------------------------------------------
public double MeanDeviation(double data[]) throws Exception{
double mean=this.mean(data),result[]=new double[data.length];
if(!this.DataIsEmpty(data)){
for (int i=0;i<data.length;i++)
{
result[i]=(data[i]-mean);

}

this.setMeanDeviation(this.summationData(result)/(double)data.length);

}
return this.getMeanDeviation();
}
//--------------------------------------------------------------------------------------

public double Variance(double data[],double freq[]) throws Exception{
double mean=0,result[]=new double[data.length];
this.mean(data,freq);
mean=this.getMean();

if(!this.DataIsEmpty(data)){
for (int i=0;i<data.length;i++)
{
result[i]=(freq[i]*(Math.pow(data[i]-mean,2)));

}

this.setVariance(this.summationData(result)/this.summationData(freq));


}
return this.getVariance();
}


//---------------------------------------------------------------------------------
//Variance
public double Variance(double data[]) throws Exception{
double mean=this.mean(data),result[]=new double[data.length];
if(!this.DataIsEmpty(data)){
for (int i=0;i<data.length;i++)
{
result[i]=Math.pow(data[i]-mean,2);

}
this.setVariance(this.summationData(result)/(double)data.length);

}
return this.getVariance();
}
//---------------------------------------------------------------------------------------
//moment bout mean
//--------------------------------------------------------------------------------------
//StandardDeviation
public double StandardDeviation(double data[]) throws Exception{
    if(!this.DataIsEmpty(data)){
this.SetStandardDeviation(Math.sqrt(this.Variance(data)));}
return this.getStandardDeviation();
}
//-----------------------------------------------------------------------------------
//StandardDeviation
public double StandardDeviation(double data[],double freq[]) throws Exception{
    if(!this.DataIsEmpty(data)){
this.SetStandardDeviation(Math.sqrt(this.Variance(data,freq)));}
return this.getStandardDeviation();
}
//--------------------------------------------------------------------------------------
public double MeanAbsolute(double data[]) throws Exception{
double mean=this.mean(data),result[]=new double[data.length];
if(!this.DataIsEmpty(data)){
for (int i=0;i<data.length;i++)
{
result[i]=Math.abs(data[i]-mean);

}

this.setMeanAbsolute(this.summationData(result)/(double)data.length);

}
return this.getMeanAbsolute();
}
//----------------------------------------------------------------------------------------------------------------
public double HarmonicMean(double data[]) throws Exception{
    
    if(!this.DataIsEmpty(data)){
    this.setHarmonicMean((data.length/summationInverseData(data)));}
return this.getHarmonicMean();



}
//--------------------------------------------------------------------------------------------------------------
public double multiplicationData(double a[]) throws Exception{

    double s=1;
    if(!this.DataIsEmpty(a)){
    for(double n:a)
        {
           
            s *= n;
    
        }
this.setMultiplicationData(s);
    }
return s;
}
//----------------------------------------------------------------------------------------------------------------
public double QuadraticMean(double data[]) throws Exception{
    if(!this.DataIsEmpty(data)){
    this.setQuadraticMean(Math.pow(this.multiplicationData(data),(1/(double)data.length)));
    }
return this.getQuadraticMean() ;

}
//----------------------------------------------------------------------------------------------------------------
public double QuadraticMean(double data[],double Freq[])throws Exception
{
    
       double[] r=new double[data.length];
    if(data.length==Freq.length){
    if(!this.DataIsEmpty(data)&&!this.DataIsEmpty(Freq)){
    for(int i=0;i<data.length;i++)
    {
    r[i]=Math.pow(data[i], Freq[i]);
    
    
    }
   
    this.setQuadraticMean(Math.pow(this.multiplicationData(r),(1/this.summationData(Freq))));
    }
    
    
    }
    
return this.getQuadraticMean() ;

}
//---------------------------------------------------------------------------------------

//----------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------

public double power(double a,int b)throws Exception
{
        double curn=1;
        if(b==0)
            {
                return 1;
            }
        else if(b>0)
            {
                curn=a*power(a,b-1);
            
            }
        else if(b<0)
           {
                b*=-1;
                curn=1/(power(a,b));

           }
return curn;
}
//-------------------------------------------------------------------------------------------------------------------------------------
public double summationData(double a[]) throws Exception{

    double s=0;
    if(!this.DataIsEmpty(a))
    for(double n:a)
        {
            s+=n;
    
        }


return s;
}
//-----------------------------------------------------------------------------------------------------------------
public double[] multiply(double a[],double freq[])
{
    double d[]=new double[a.length];
    
    for(int i=0;i<d.length;i++)
            {
                d[i]= a[i]*freq[i];

            }
return d;
}
//--------------------------------------------------------------------------------------------------------------
public void dataIsPower(double a[],int power)throws Exception
{
     for(int i=0;i<a.length;i++)
            {
                a[i]=power(a[i],power);
    
            }


}
//---------------------------------------------------------------------------------------------------------
public double[] comuliveFrequancy(double frequancy[])
{
    double comulative[]=new double[frequancy.length];
    double n=0;
    for(int i=0;i<frequancy.length;i++)
            {
    
                    n+=frequancy[i];
                    comulative[i]=n;
            }
    
    

   this.setCommulativeFrequancy(comulative);
return comulative;
}
//------------------------------------------------------------------------------------------------------------
public double[] RelativeFrequancy(double freq[]) throws Exception
{
    double relativeFreuancy[]=new double[freq.length];
    double n=0;
    n=summationData(freq);

    for(int i=0;i<freq.length;i++)
            {
                relativeFreuancy[i]=freq[i]/n;
    
            }
    this.setRelativeFreuancy(relativeFreuancy);
    
return relativeFreuancy;
}
//----------------------------------------------------------------------------------------------------------
   
//percent
//------------------------------------------------------------------------------------------------------------
public double[] percentFrequancy(double freq[]) throws Exception
{
    double relativeFreuancy[]=new double[freq.length];
    double n=0;
    n=summationData(freq);

    for(int i=0;i<freq.length;i++)
            {
                relativeFreuancy[i]=(freq[i]/n)*100;
    
            }
    this.setRelativeFreuancy(relativeFreuancy);
    
return relativeFreuancy;
}
//-------------------------------------------------------------------------------
public double MeanFreqRelative(double data[],double freq[]) throws Exception    
{
double []a=RelativeFrequancy(freq),b=comuliveFrequancy(freq),c= multiply(data, freq);
        this.setData(data);
        this.setFrequncy(freq);
        setArray(new Object[data.length+1][6]);
 if(!this.DataIsEmpty(data)&&!this.DataIsEmpty(freq))
    {
    
        for(int i=0;i<6;i++)
                {
                    for(int j=0;j<data.length;j++)
                        {
                            if(i==0)//for insert all Data
                                {
                                   getArray()[j][i]=data[j];
                                   if(j+1==data.length)
                                        {
                                           this.setSumData(summationData(data));//this sammation of all data 
                                           getArray()[j+1][i]=this.getSumData();
                                        }
                                }                     
                            else if(i==1)//for insert frequancy
                                {
                                    getArray()[j][i]=freq[j];
                                    if(j+1==data.length)
                                            {
                                                this.sumFreq=summationData(freq);//this summation of all frequancy
                                               getArray()[j+1][i]= this.sumFreq;
                                            }
   
                                }
                            else if(i==2)//insert all relative frequancy
                                {
   
                                    getArray()[j][i]=a[j];
                                }
                            else if(i==3)//insert all commulative frequancy 
                               {
                                    getArray()[j][i]= b[j];
   
   
                               }
                            else if(i==4)//data multyplied by frequancy 
                               {
   
                                    getArray()[j][i]=c[j];
                                    if(j+1==data.length)
                                        {
                                            this.sumDataFreq=summationData(c);//this sammation of data*frequancy
                                            getArray()[j+1][i]=this.sumDataFreq;
                                        }
     
                                }else if(i==5)
                                {
                                
                                
                                 getArray()[j][i]=a[j]*100;
                                }
    
      
      
                        }
    
                }
                 setTitle(new String[]{"data","frquancy","relative frequancy","comulitive frequancy","data*frequancy","percent"});
    }
else
    {
    
    
       throw  new  Exception("Data is Empty can not process it !!!");
    }
    
    return (summationData(c)/(double)data.length);
}
//------------------------------------------------------------------------------
public boolean DataIsEmpty(double data[])throws Exception
{
    double a=data.length;
    boolean t=false;
 
    if (a==0.0)
            {
                 t= true ;
            }
    else
            {
                Exception exception = new Exception("Empty Data");
            }
       return t;
    

}
    /**
     * @return the sumData
     */
    public double getSumData() {
        return sumData;
    }
    /**
     * @param sumData the sumData to set
     */
    public void setSumData(double sumData) {
        this.sumData = sumData;
    }
    /**
     * @return the sumFreq
     */
    public double getSumFreq() {
        return sumFreq;
    }
    /**
     * @param sumFreq the sumFreq to set
     */
    public void setSumFreq(double sumFreq) {
        this.sumFreq = sumFreq;
    }
    /**
     * @return the sumDataFreq
     */
    public double getSumDataFreq() {
        return sumDataFreq;
    }
    /**
     * @param sumDataFreq the sumDataFreq to set
     */
    public void setSumDataFreq(double sumDataFreq) {
        this.sumDataFreq = sumDataFreq;
    }
    /**
     * @return the array
     */
    public Object[][] getArray() {
        return array;
    }
    /**
     * @param array the array to set
     */
    public void setArray(Object[][] array) {
        this.array = array;
    }
    /**
     * @return the title
     */
    public String[] getTitle() {
        return title;
    }
    /**
     * @param title the title to set
     */
    public void setTitle(String[] title) {
        this.title = title;
    }
    /**
     * @return the mean
     */
    public  double getMean() {
        return mean;
    }
    /**
     * @return the relativeFreuancy
     */
     public double[] getRelativeFreuancy() {
        return relativeFreuancy;
    }
    /**
     * @param relativeFreuancy the relativeFreuancy to set
     */
    public void setRelativeFreuancy(double[] relativeFreuancy) {
        this.relativeFreuancy = relativeFreuancy;
    }
    /**
     * @return the commulativeFrequancy
     */
    public double[] getCommulativeFrequancy() {
        return commulativeFrequancy;
    }
    /**
     * @param commulativeFrequancy the commulativeFrequancy to set
     */
     public void setCommulativeFrequancy(double[] commulativeFrequancy) {
        this.commulativeFrequancy = commulativeFrequancy;
    }
    /**
     * @return the percent
     */
     public double[] getPercent() {
        return percent;
    }
    /**
     * @return the data
     */
     public double[] getData() {
        return data;
    }
    /**
     * @param data the data to set
     */
    public void setData(double[] data) {
        this.data = data;
    }
    /**
     * @return the frequncy
     */
      public double[] getFrequncy() {
        return frequncy;
    }
    /**
     * @param frequncy the frequncy to set
     */
    public void setFrequncy(double[] frequncy) {
        this.frequncy = frequncy;
    }
    /**
     * @return the GeometricMean
     */
     public double getGeometricMean() {
        return GeometricMean;
    }
    /**
     * @param GeometricMean the GeometricMean to set
     */
     public void setGeometricMean(double GeometricMean) {
        this.GeometricMean = GeometricMean;
    }
    /**
     * @return the HarmonicMean
     */
    public double getHarmonicMean() {
        return HarmonicMean;
    }
    /**
     * @param HarmonicMean the HarmonicMean to set
     */
     public void setHarmonicMean(double HarmonicMean) {
        this.HarmonicMean = HarmonicMean;
    }
    /**
     * @return the Mode
     */
     public double getMode() {
        return Mode;
    }
    /**
     * @param Mode the Mode to set
     */
     public void setMode(double Mode) {
        this.Mode = Mode;
    }
    /**
     * @return the Median
     */
     public double getMedian() {
        return Median;
    }
    /**
     * @param Median the Median to set
     */
    public void setMedian(double Median) {
       
        this.Median = Median;
    }
    /**
     * @return the commulativeRelativefreqancy
     */
    public double[] getCommulativeRelativefreqancy() {
        return commulativeRelativefreqancy;
    }
    /**
     * @param commulativeRelativefreqancy the commulativeRelativefreqancy to set
     */
     public void setCommulativeRelativefreqancy(double[] commulativeRelativefreqancy) {
        this.commulativeRelativefreqancy = commulativeRelativefreqancy;
    }
    /**
     * @return the QuadraticMean
     */
  public double getQuadraticMean() {
        return QuadraticMean;
    }
    /**
     * @param QuadraticMean the QuadraticMean to set
     */
    public void setQuadraticMean(double QuadraticMean) {
        this.QuadraticMean = QuadraticMean;
    }    
    /**
     * @param mean the mean to set
     */
    public  void setMean(double mean) {
        this.mean = mean;
    }
    /**
     * @return the multiplicationData
     */
    public  double getMultiplicationData() {
        return multiplicationData;
    }
    /**
     * @param multiplicationData the multiplicationData to set
     */
    public  void setMultiplicationData(double multiplicationData) {
        this.multiplicationData = multiplicationData;
    }
     /**
     * @return the multiplicationData
     */
    public  double getMeanDeviation() {
        return MeanDeviation;
    }
    /**
     * @param MeanDeviation
     */
    public  void setMeanDeviation(double MeanDeviation) {
        this.MeanDeviation= MeanDeviation;
    }
     /**
     * @param Range    
     */
    public void setRange(double Range){
    this.Range=Range;
    
    }
     /**    
     * @return  Range   
     */
    public double getRange(){
    return this.Range;
    }
    /**
     * @return the multiplicationData
     */
    public  double getMeanAbsolute() {
        return MeanAbsolute;
    }
    /**
     * @param MeanAbsolute the multiplicationData to set
     */
    public  void setMeanAbsolute(double MeanAbsolute) {
        this.MeanAbsolute = MeanAbsolute;
    }
    /**
     * @return Variance
     */
    public  double getVariance() {
        return Variance;
    }
    /**
     * @param Variance
     */
    public  void setVariance(double Variance) {
        
        this.Variance= Variance;
        
    }
    /**
     * @return StandardDeviation
     */
    public  double getStandardDeviation() {
        return StandardDeviation;
    }
    /**
     * @param StandardDeviation
     */
    public  void SetStandardDeviation(double StandardDeviation) {
        
        this.StandardDeviation= StandardDeviation;
        
    }
    //MomentAboutR
       /**
     * @return MomentAboutR
     */
    public  double getMomentAboutR() {
        return MomentAboutR;
    }
    /**
     * @param MomentAboutR
     */
    public  void SetMomentAboutR(double MomentAboutR) {
        
        this.MomentAboutR= MomentAboutR;
        
    }
//MomentAboutOrigin
    
       /**
     * @return MomentAboutR
     */
    public  double getMomentAboutOrigin() {
        return MomentAboutOrigin;
    }
    
    /**
     * @param MomentAboutOrigin
     */
    public  void MomentAboutOrigin(double MomentAboutOrigin) {
        
        this.MomentAboutOrigin= MomentAboutOrigin;
        
    }

    public void summationeDifferentDataAndMean(double[][] Y, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
