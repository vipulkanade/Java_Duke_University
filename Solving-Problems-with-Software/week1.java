import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int totalNums = 0;
        Point p = s.getLastPoint();
        for (Point cp : s.getPoints()) {
            totalNums++;
        }
        return totalNums;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        return (getPerimeter(s)/getNumPoints(s));
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largestSide = 0.0;
        
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            
            if (largestSide < currDist) {
                largestSide = currDist;
            }
            
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0.0;
        for (Point currPt : s.getPoints()) {
            if (largestX < Math.abs(currPt.getX())) {
                largestX = currPt.getX();
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles(DirectoryResource dr) {
        // Put code here
        double largestPerimeter = 0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if (largestPerimeter < length) {
                largestPerimeter = length;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter(DirectoryResource dr) {
        // Put code here
        File temp = null;    // replace this code
        double largestPerimeter = 0.0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if (largestPerimeter < length) {
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numsPoints = getNumPoints(s);
        System.out.println("number of points = " + numsPoints);
        double averageLength = getAverageLength(s);
        System.out.println("Average Length = " + averageLength);
        double largestSide = getLargestSide(s);
        System.out.println("largest side = " + largestSide);
        double largestX = getLargestX(s);
        System.out.println("largest X = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        System.out.println("largest perimeter = " + getLargestPerimeterMultipleFiles(dr));
        System.out.println("largest perimeter file name = " + getFileWithLargestPerimeter(dr));
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
    }
}

