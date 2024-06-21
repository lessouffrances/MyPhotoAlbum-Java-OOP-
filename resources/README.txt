*PhotoAlbum - Part2*

Submitted by: **Panyu Dong**

**Name of your app** is an app that lets users create multiple shapes and 
add them to the photo album, where users can change the features of the shapes(color, size, location), can change the scheme of the photo album(add or remove shapes), users can also take snapshots of the album and have these snapshots retrieved later or clean storage of the snapshots.

## Note
This part of code is the modified Model part plus Controller and View 
following the MVC paradigm.

Time spent: **17** hours spent in total

## Required Features

The following **required** functionality is completed:

- [x] User can create multiple shapes by the factory class.
- [x] User can create multiple shapes by the concrete classes.
- [x] User can change the features of multiple shapes(size, location and color).
- [x] User can create a photo album by adding shapes, modify it by removing shapes.
- [x] User can take snapshots of the photo album and have the snapshots stored somewhere.
- [x] User can retrieve the snapshots based on the date information.
- [x] User can reset the snapshots taken by the present time.
- [x] User can have an overview of the photo album.
- [x] User can have an observation of the state changes of the photo album.

## Design Rationale
Each package has sole responsibility with segregated interfaces.
Here is a brief overview of the architecture:
* shapes: IShape <- Shape2D <- concrete shapes 
* transformation: ITransformation <- concrete transformations
* solid design: IFactory <- concrete ShapeFactory
* album: IPhotoAlbum <- PhotoAlbum
         ISnapshot <- Snapshot
* controller:
         ICommand <- BaseCommand <- ColorChangeCommand 
                                    MoveCommand
                                    ResizeCommand
                                    ShapeCommand
                                    TakeSnapshotCommand
         Controller <- Controller
* view: IWebVeiw <- WebView
        JPanel <- DrawingPanel
        JFrame <- GraphicalView
* PhotoAlbumMain class
* test: like clients, stays outside of these assets.

### package 1: shapes 
* For the basic elements like shapes, create an IShape interface 
  and push all the repeating code from concrete shapes classes into a Parent class 'Shape2D' 
  to stay D.R.Y.

* Considering the users' not knowing about RGB values, 
create a ColorEnum and choose a number of default colors 
that users can choose upfront when they create the shape. 

* In the UML, class Shape2D implements the Interface IShape, 
and concrete shape classes extends class Shape2D.

### package 2: soliddesign
* For users' lack of domain knowledge and information hiding, 
  users can ask for shapes called from 
  the default constructors of the concrete class by simply passing in the name of that shape.

* For reusability and flexibility, new shapes can be plugged into the creators once needed.
  Shapes can be handed out quickly. A new Triangle class has been created and plugged into the 
  factory and it conforms well to the system.

* In the UML, ShapeFactory implements the interface IFactory.

### package 3: transformation 
* For separation of concerns, users are more designed to change the features of their shapes 
  using the outside transformation, not the methods inside the concrete shapes classes.

* Even though there are plausible ways to change features using the methods in the 
  concrete shapes classes, that's not the purpose of the design. 
  The main purpose of the concrete shapes classes are more for object creation, 
  but not for users to change the features of the shapes.

* Users are designed to change the features of the shapes by transformation assets. 
  Users can create the specific transformation(size, location, and color) and apply it 
  to the passed-in shape.

* In the UML, concrete transformation classes implement the Interface ITransformation.

### package 4: album
* The photo album class communicates with both shape classes and snapshot class, 
  because there are two lines of functions in the album: one is for the photo album itself,
  another is for the snapshots.

* In the UML, a photo album implements the interface and can have multiple shapes and snapshots;
              a snapshot implements the interface and can have multiple shapes when taken.

* Consider the future development of the photo album, two methods are added:
   1. applyTransformation() in a photo album level. Users can choose some but not all the shapes 
   from the album and have a certain transformation applied on them.
   2. getSnapshotsByDate() in a photo album level. Users can entering a date, and have the
   snapshots taken on that date be retrieved. 

* Both lines of functions are rendered to the console by different string methods, 
  and both line of elements are stores in separate lists. 

### package 5: controller
Two parts involved but both handle users inputs and coordinate the model and the view.
Part 1): ICommand: Command Pattern, use multiple techniques(parse, iterators, etc) to retrieve information from users' input. 
Under the ICommand, there is a parent Command class called BaseCommand and its 5 concrete command classes to deal with different kinds of commands. 

Part 2): IController: It defines multiple methods to be the mediation between the view 
and the model. Under the IController, the real controller class implements the methods, 
talking to both view and the model. 

### package 6: view
The view contains a GraphicalView class that inherits from JFrame, as well as a WebView class. The GraphicalView class uses a DrawingPanel, which inherits from JPanel, to draw images.

### Modifications that are necessary for the view
Changes are made for information retrieval (namely, adding proper getters) 
&& deep copy (keep information immutable) that are better adapted to the required view:
Changes:
    Add methods in PhotoAlbum:
        public void takeSnapshot(String description)
        public List<Snapshot> getSnapshots()
    Add fields and methods in Snapshot:
        private String description;
        public List<IShape> getShapes()
        public String getDescription()
    Add methods in IShape:
        String getName()
        IShape clone()
    Add field in Shape2D.java and change the constructor of the Shape2D class
                              
## License

    Copyright [2024] [Panyu Dong]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
