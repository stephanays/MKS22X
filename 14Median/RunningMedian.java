public class RunningMedian{

    MyHeap maxHeap;
    MyHeap minHeap;
    int maxSize;
    int minSize;
    int choose;

    public RunningMedian(){
	
	maxHeap = new MyHeap();
	minHeap = new MyHeap(false);
	maxSize = 0;
	minSize = 0;
	choose = 0;

    }

    public void add(int n){
	if (n > this.getMedian()){
	    minHeap.add(n);
	    minSize += 1;
	}
	else{
	    if(n < this.getMedian()){
		maxHeap.add(n);			
		maxSize += 1;
	    }
	    else{
		if (choose % 2 == 0){
		    maxHeap.add(n);
		    maxSize += 1;

		}
		else{
		    minHeap.add(n);
		    minSize += 1;

		}
		choose += 1;
	    }
	}

	//have to do the balancing thingymabob
	if (maxSize > minSize + 1){
	    minHeap.add(maxHeap.remove());
	    minSize += 1;
	    maxSize -= 1;
	}

	if (minSize > maxSize + 1){
	    maxHeap.add(minHeap.remove());
	    minSize -= 1;
	    maxSize += 1;
	}
	  

    }

    public double getMedian(){
	
	if(maxSize == 0 && minSize == 0){
	    return 0;
	}
	
	if(maxSize == minSize){
	    return (maxHeap.peek() + minHeap.peek()) / 2.0;
	}
	else{
	    if (maxSize > minSize){
		return maxHeap.peek();
	    }
	    else{
		return minHeap.peek();
	    }
	}
    }


    public static void main(String[] args){
	RunningMedian x = new RunningMedian();
	x.add(15);
	x.add(25);
	x.add(35);
	x.add(45);
	x.add(60);
	x.add(0);
	System.out.println(x.getMedian());
    }

}
