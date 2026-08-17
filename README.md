# NDT Radiography Calculator
A Java Swing desktop application created for Non-Destructive Testing (NDT) radiography applications. This tool allows NDT technicians and inspectors to quickly compute required distances and exposure time adjustments through an intuitive tabbed interface.  

## Features
* SOD & SFD Estimator:
Determines minimum Source-to-Object Distance (SOD).  
Outputs total Source-to-Film Distance (SFD).  
* Exposure Time Adjuster:
Calculates new required exposure times when changing setup distances. 
* User Interface:
Tabbed interface for smooth navigation.  Input validation with clear error messages for invalid or missing values.

## Project Structure
```
├── RadiographyCalculator.java  # Main application launcher & frame setup
├── RadiographyService.java     # Backend processing service
├── SODPanel.java              # Interface panel for SOD/SFD inputs
└── TimePanel.java             # Interface panel for Exposure Time inputs
```
