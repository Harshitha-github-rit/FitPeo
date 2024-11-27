Prerequisites
Before you start setting up the project, ensure you have the following installed:
1.	Eclipse IDE (for Java Developers)
o	Download from Eclipse Downloads.
2.	Java Development Kit (JDK) 11 or higher
o	Download from Oracle's JDK Download.
o	You can check if Java is installed by running:
java -version
3.	Maven (for dependency management)
o	Maven comes pre-installed in Eclipse, but if you need to install it separately, download from Maven Downloads.
o	Check if Maven is installed:
		mvn -v
4.	Install Git:
o	If you don’t have Git installed, download and install it from Git Downloads.




Clone the Repository
Step 1: Copy the Repository URL
Repository URL: https://github.com/Harshitha-github-rit/FitPeo/tree/master 
1.	Open your GitHub repository in a browser.
2.	Click the green Code button at the top-right of the repository.
3.	Choose your preferred method:
o	HTTPS: Default option; URL format is https://github.com/Harshitha-github-rit/FitPeo.git.

Step 2: Open Your Git Bash
1.	Navigate to the directory where you want to clone the repository
		cd /path_to_your_desired_folder

Step 3: Run the Clone Command
	git clone https://github.com/Harshitha-github-rit/FitPeo.git




Setting Up the Project in Eclipse
1.	Open Eclipse IDE and select a workspace (a directory where your project will be stored).
2.	Import the Maven Project:
o	Go to File > Open project from file system.
o	In the Directory field, browse and select the project directory that you cloned.
o	Eclipse will automatically detect the pom.xml file and list the project. Select it and click Finish.
3.	Eclipse will now import the project, and the Maven dependencies will be automatically downloaded and integrated.
4.	Go to the runner Folder, right click on testRunner java file and then click on run as  Junit Test  it will execute the project.


