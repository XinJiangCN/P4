# P4
cs 367 Program 4

<div id="assignment_show" class="assignment content_underline_links">
    <!--Student View-->
    <div class="assignment-title">
      <div class="title-content">
        <h1 class="title">
          p4
        </h1>
      </div>
      <div class="assignment-buttons">
        <span style="display: inline-block">
          
        </span>
        <a class="btn btn-primary submit_assignment_link " href="#">Submit Assignment</a>
      </div>
    </div>
    <ul class="student-assignment-overview">
      <li>
        <span class="title">Due</span>
        <span class="value">
          <span class="date_text">
                <span class="display_date">Apr 16</span> by 
                <span class="display_time">10pm</span>
          </span>
        </span>
      </li>
      <li>
        <span class="title">Points</span>
        <span class="value">50</span>
      </li>
        <li>
          <span class="title">Submitting</span>
          <span class="value">a file upload</span>
        </li>
          <li>
            <span class="title">File Types</span>
            <span class="value">java</span>
          </li>
        <li>
    <span class="title">Available</span>
    <span class="value">
        Mar 27 at 4pm - Apr 16 at 10pm
        <span style="font-size: 0.8em;">20 days</span>
    </span>
  </li>

      <div class="clear"></div>
    </ul>

  <div class="clear"></div>


  <div class="clear"></div>

  <div class="description user_content student-version enhanced"><h2>CS 367 Programming Assignment 4:&nbsp;Schedule Planner</h2>
<p><span style="color: #990000; font-size: 12pt;"><strong>DUE by 10:00 PM on Sunday,&nbsp;April 16th</strong><br></span> <br> <a href="#Announcements">Announcements</a> | <a href="#Overview">Overview</a> | <a href="#Specifications">Specifications</a> | <a href="%22#IO">Input/Output</a> | <a href="#Classes">Classes and Interfaces</a>&nbsp;|&nbsp;<a href="#Javadocs" target="">Javadocs</a> | <a href="#Steps">Steps</a> | <a href="#Submission">Submission</a></p>
<p class="announcements"><a name="Announcements"></a></p>
<h2>Announcements</h2>
<p>Corrections, clarifications, and other announcements regarding this programming assignment will be found below.</p>
<ul>
<li>
<span style="color: #000000;"><span style="color: #000000;"><strong>4/7:&nbsp;</strong>IntervalTreeADT.findOverlapping() method must include intervals which overlap on the edge point as well. For example: p1 [4, 10] and p2 [10, 15] will overlap. Javadocs for this method should be:</span></span>&nbsp;
<div id="questionText" class="post_region_text">
<p>if left subtree's max is greater than <strong><em>or equal</em></strong>&nbsp;to the interval's start, call findOverlappingHelper in the left subtree.</p>
<p>if right subtree's max is greater than <em><strong>or equal</strong></em>&nbsp;to the interval's start, call call findOverlappingHelper in the rightSubtree.</p>
<p>The javadocs have been updated and p4.zip has been updated with this change in the method comments for IntervalTreeADT.findOverlapping() ADT</p>
</div>
<span style="color: #000000;"><span style="color: #000000;"></span></span>
</li>
<li><span style="color: #000000;"><span style="color: #000000;"><strong>4/7:&nbsp;</strong>In IntervalTreeMain, it throws NullPointerException if you don't pass in argument datafile in the interactive mode as well. There are two ways to deal with it: either pass in datafile "java IntervalTreeMain 1 datafile" or apply the fix described in this piazza note here:&nbsp;<a href="https://piazza.com/class/ixvb3zbhyqd29e?cid=515" class="external" target="_blank" rel="noreferrer"><span><span>https://piazza.com/class/ixvb3zbhyqd29e?cid=515</span><span class="screenreader-only">&nbsp;(Links to an external site.)</span></span><span class="ui-icon ui-icon-extlink ui-icon-inline" title="Links to an external site."></span></a>. Either way it doesn't affect the correctness of your program's TODOs.</span></span></li>
<li><span style="color: #000000;"><strong>3/27:</strong>&nbsp;In IntervalTreeADT insert method comments: ...Use the comparator defined in&nbsp;<strong>Interval</strong> and create a new IntervalNode to store the new<span style="font-family: monospace;"><span style="font-size: 13.3333px;">&nbsp;interval</span></span></span></li>
<li><span style="color: #000000;">p4 Teams will be the same as p3 teams.</span></li>
<li>
<strong style="font-size: 0.875rem;">3/27:</strong><span style="font-size: 0.875rem;"> Program 4 assigned.&nbsp;</span><span style="font-size: 0.875rem;">A link to Piazza is available for students to ask questions about the assignment.</span>
</li>
<li><span>REMINDER: Students may share work only with other members of their same team. &nbsp;Students caught posting course work online (i.e. for seeking help or a paid programmer) will get a zero on the assignment and potentially fail the course.</span></li>
</ul>
<p>&nbsp;</p>
<div>
<a name="Overview"></a>
<h2>Overview</h2>
<h3>Goals</h3>
<p>The goals of this assignment are to:</p>
<ul>
<li>Understand, implement, and use a Binary Search Tree type</li>
<li>Introduce you to a new ADT, an Interval Tree</li>
<li>Write classes that implement Java interfaces</li>
<li>Gain experience working with Java references</li>
<li>Implement methods recursively (in most cases using a recursive helper method).</li>
</ul>
<h3>Description</h3>
<p>In this project, you will implement a basic version of Schedule Planner. In every semester, we have a number of days (let's say days are numbered 1 through 120) and we have multiple courses each with multiple assignments. For example, CS367 has projects P1 through P5 and each project is available within a specified time window (e.g.,&nbsp;P1 day 20 through day 40, P2 day 22 through day 35 and so on). In this assignment, we will construct a data structure to store projects with time-windows during which they are available and will answer questions like: If your birthday is on day 51st, how many/what all projects will "overlap" with your birthday. Suppose, you enrolled in another class, so you would want to "insert" a new Project and time-window in your schedule planner.</p>
<p>We will represent above schedules as intervals. Each interval is represented as&nbsp;<span>&nbsp;&lt;label&gt; [start &nbsp;end] where label is the name of the project/schedule and [start &nbsp;end] represents&nbsp;the span of the project/appointment in your calendar. There can be overlapping intervals: e.g., P1 [10 30], P2 [20 27], here P1 and P2 have overlapping time-windows.&nbsp;</span>You will write a variation of Binary Search Tree called IntervalTree to store these intervals and support various queries (see below for what queries are supported). Each node will represent a project schedule/appointment. Each node will have [start, end] as its <strong>data</strong> values, and the <strong>key</strong> for comparison will be first the 'start' value and then if 'start' are same, you'll compare the 'end' values. Each node in the IntervalTree will also store a <strong>maxEnd</strong> variable which represents the maximum end present in the subtree rooted at node 'n'. &nbsp;For example, a diagram of such a tree may look like this:</p>
<p><br><img style="display: block; margin-left: auto; margin-right: auto; max-width: 561px;" src="/courses/23073/files/1017786/preview" alt="interval-tree.jpg" width="598" height="397" data-api-endpoint="https://canvas.wisc.edu/api/v1/courses/23073/files/1017786" data-api-returntype="File">&nbsp;</p>
</div>
<p><a name="Specifications"></a></p>
<p>As you can see in the above tree, each node represents the interval which denotes the appointment/schedule in your calendar. Notice that <strong>maxEnd</strong> is the maximum end in the <em>subtree</em> rooted at that node. So, if you delete/insert an interval, it's going to affect the <strong>maxEnd</strong> of possibly multiple nodes in the path from root to the node you deleted/inserted.</p>
<p>Purpose of <strong>maxEnd</strong>: <strong>maxEnd</strong>&nbsp;is used to reduce the search complexity of the program. For example, in the tree shown above, if we are searching for intervals overlapping [58 65], we can avoid left subtree as its maxEnd is 55 so no interval will overlap with the target input interval. You should keep this in mind while writing your code.</p>
<h2>Specifications</h2>
<h3>Operations&nbsp;supported</h3>
<p>1. <strong>Insert Schedule</strong>: This operation will let the user enter the schedule as an Interval specified by&lt;label&gt; [start, end] and will insert this into the IntervalTree. Remember to update the maxEnd of the affected nodes as you insert a new interval.</p>
<p>2. <strong>Delete Schedule</strong>: This operation will let the user enter the schedule&lt;label&gt; [start, end] and will remove it from the tree. So essentially you will remove the node with the specified interval. Remember to update the maxEnd of the affected nodes.</p>
<p>3. <strong>Find</strong>&nbsp;<strong>Overlap Schedule</strong>: This operation will allow the user to enter a schedule [start, end] and will return all the schedules which overlap with the input schedule. For example, in above tree, for interval [30 42], the program will return [32 39], [41 55].</p>
<p class="p1">4. <strong>Schedules Containing Point</strong>:<strong>&nbsp;</strong>This will return a list of intervals containing the input point. For example, suppose we have intervals [12 15], [20 30], [13 18] in our tree, and input point is 15, then the program will return intervals [12 15], [13 18]. &nbsp;Labels of each interval are not considered for matches.</p>
<p>5. <strong>Print Tree&nbsp;Stats</strong>: This will print out the stats such as number of nodes and height of the tree.</p>
<p>6. <strong>Show Tree Viewer</strong>: This will launch a window to show Tree. You can use it to debug your tree.</p>
<p>7. <strong>Quit</strong>: This will quit the program.</p>
<p><a name="Classes"></a></p>
<h2>Important Types (classes and interfaces)</h2>
<h4><span style="font-family: monospace;">interface&nbsp;IntervalADT (provided to you -- do not change)</span></h4>
<p style="padding-left: 30px;">IntervalADT defines the interface for representing targets. You must implement all methods in a new class&nbsp;<span style="font-family: monospace; font-size: 10pt;">Interval.</span></p>
<h4><strong>interface IntervalTreeADT (provided to you -- do not change)</strong></h4>
<p style="padding-left: 30px;">This interface defines required operations of the IntervalTree. It has functions for tree operations like: insert, delete, height, size. You must implement all of these functions in a new class&nbsp;<span>IntervalTree.</span></p>
<h4></h4>
<h3>Classes that you must define or complete:</h3>
<h4>
<span style="font-family: monospace;">class Interval implements IntervalADT&nbsp;</span>(TODO -- complete this class)</h4>
<p style="padding-left: 30px;"><span style="font-family: monospace;"></span>This class implements the <strong>IntervalADT</strong>&nbsp;interface. &nbsp;Create, edit, and submit this file.</p>
<h4>
<span style="font-family: monospace;">class IntervalTree implements IntervalTreeADT&nbsp;</span>(TODO -- complete this class)</h4>
<p style="padding-left: 30px;"><span style="font-family: monospace;"></span>This class implements the <strong>IntervalTreeADT</strong> interface. &nbsp;Create, edit, and submit this file.</p>
<h4>
<span style="font-family: monospace;">class IntervalNode&nbsp;</span>(TODO -- complete this class)</h4>
<p style="padding-left: 30px;"><span style="font-family: monospace;"></span>This class has been partially defined for you. &nbsp;It implements the getter and setters for node members and it provides a getSuccessor() method to get the in-order successor of the node. &nbsp;You must implement the getSuccessor() method.</p>
<h4><span style="font-family: monospace;"></span></h4>
<h3>To program run program, execute IntervalTreeMain</h3>
<p>This class contains the main method of the program. &nbsp;It has been provided to you and you should not need to edit.</p>
<p>The program runs in one of two modes: (1) InteractiveMode and (2) nonInteractive mode.</p>
<p>The interactive mode opens up a main menu interface where you can specify operations to do with the tree (e.g., insert, delete, print stats, etc.).</p>
<p>Non-interactive mode runs the program using a text-file which contains a bunch of intervals and runs some queries e.g., insert/delete/overlap etc. In order to debug and/or develop program incrementally, you may prefer to use the Interactive mode.</p>
<ul>
<li>javac *.java</li>
<li><span>java IntervalTreeMain 1</span></li>
</ul>
<p><span>Alternatively specify "1" (without quotes) in the Arguments tab in Eclipse Run Configuration.</span></p>
<p><span style="font-size: 0.875rem;">The following is a sample Input/Output sequence:.</span></p>
<pre class="p1">Welcome to Schedule Planner!<br>=============================<br><br>1. Insert Schedule<br>2. Delete Schedule<br>3. Find Overlapping Schedules<br>4. Schedules Containing Point<br>5. Print Tree Stats<br>6. Show Tree Viewer<br>7. Quit Program<br><br>Enter Choice: 1<br>Selected Insert Schedule<br>Enter &lt;label start end&gt;: <br>p1 5 10<br>Successfully inserted: p1 [5, 10]<br><br>1. Insert Schedule<br>2. Delete Schedule<br>3. Find Overlapping Schedules<br>4. Schedules Containing Point<br>5. Print Tree Stats<br>6. Show Tree Viewer<br>7. Quit Program<br><br>Enter Choice: 1<br>Selected Insert Schedule<br>Enter &lt;label start end&gt;: <br>p2 2 15<br>Successfully inserted: p2 [2, 15]<br><br>1. Insert Schedule<br>2. Delete Schedule<br>3. Find Overlapping Schedules<br>4. Schedules Containing Point<br>5. Print Tree Stats<br>6. Show Tree Viewer<br>7. Quit Program<br><br>Enter Choice: 1<br>Selected Insert Schedule<br>Enter &lt;label start end&gt;: <br>p3 12 20<br>Successfully inserted: p3 [12, 20]<br><br>1. Insert Schedule<br>2. Delete Schedule<br>3. Find Overlapping Schedules<br>4. Schedules Containing Point<br>5. Print Tree Stats<br>6. Show Tree Viewer<br>7. Quit Program<br><br>Enter Choice: 1<br>Selected Insert Schedule<br>Enter &lt;label start end&gt;: <br>p4 10 30<br>Successfully inserted: p4 [10, 30]<br><br>1. Insert Schedule<br>2. Delete Schedule<br>3. Find Overlapping Schedules<br>4. Schedules Containing Point<br>5. Print Tree Stats<br>6. Show Tree Viewer<br>7. Quit Program<br><br>Enter Choice: 5<br>Selected Tree Stats<br>-----------------------------------------<br>Height: 3<br>Size: 4<br>-----------------------------------------<br><br>1. Insert Schedule<br>2. Delete Schedule<br>3. Find Overlapping Schedules<br>4. Schedules Containing Point<br>5. Print Tree Stats<br>6. Show Tree Viewer<br>7. Quit Program<br><br>Enter Choice: 6<br>Selected Show Tree Viewer</pre>
<pre class="p1"><img src="/courses/23073/files/1016340/preview" alt="gui.png" width="435" height="279" data-api-endpoint="https://canvas.wisc.edu/api/v1/courses/23073/files/1016340" data-api-returntype="File" style="max-width: 561px;"><br><br>1. Insert Schedule<br>2. Delete Schedule<br>3. Find Overlapping Schedules<br>4. Schedules Containing Point<br>5. Print Tree Stats<br>6. Show Tree Viewer<br>7. Quit Program<br><br>Enter Choice: 2<br>Selected Delete Schedule<br>Enter &lt;label start end&gt;: <br>p4 10 30<br>Successfully deleted p4 [10, 30]<br><br>1. Insert Schedule<br>2. Delete Schedule<br>3. Find Overlapping Schedules<br>4. Schedules Containing Point<br>5. Print Tree Stats<br>6. Show Tree Viewer<br>7. Quit Program<br><br>Enter Choice: 2<br>Selected Delete Schedule<br>Enter &lt;label start end&gt;: <br>p4 5 30<br>Interval: p4 [5, 30] not found in the tree.<br><br>1. Insert Schedule<br>2. Delete Schedule<br>3. Find Overlapping Schedules<br>4. Schedules Containing Point<br>5. Print Tree Stats<br>6. Show Tree Viewer<br>7. Quit Program<br><br>Enter Choice: 4<br>Selected Schedules Containing Point<br>Enter &lt;point&gt;: <br>12<br>Following schedules contain the input point 12:<br>p2 [2, 15] p3 [12, 20] <br><br>1. Insert Schedule<br>2. Delete Schedule<br>3. Find Overlapping Schedules<br>4. Schedules Containing Point<br>5. Print Tree Stats<br>6. Show Tree Viewer<br>7. Quit Program<br><br>Enter Choice: 5<br>Selected Tree Stats<br>-----------------------------------------<br>Height: 2<br>Size: 3<br>-----------------------------------------<br><br>1. Insert Schedule<br>2. Delete Schedule<br>3. Find Overlapping Schedules<br>4. Schedules Containing Point<br>5. Print Tree Stats<br>6. Show Tree Viewer<br>7. Quit Program<br><br>Enter Choice: 3<br>Selected Find Overlapping Schedules<br>Enter &lt;start end&gt;: <br>15 30<br>Your input overlaps following schedules:<br><span style="background-color: #ffff00;">p2 [2, 15] p3 [12, 20] </span><br><br>1. Insert Schedule<br>2. Delete Schedule<br>3. Find Overlapping Schedules<br>4. Schedules Containing Point<br>5. Print Tree Stats<br>6. Show Tree Viewer<br>7. Quit Program<br><br>Enter Choice: 3<br>Selected Find Overlapping Schedules<br>Enter &lt;start end&gt;: <br>1 100<br>Your input overlaps following schedules:<br>p1 [5, 10] p2 [2, 15] p3 [12, 20] <br><br>1. Insert Schedule<br>2. Delete Schedule<br>3. Find Overlapping Schedules<br>4. Schedules Containing Point<br>5. Print Tree Stats<br>6. Show Tree Viewer<br>7. Quit Program<br><br>Enter Choice: 4<br>Selected Schedules Containing Point<br>Enter &lt;point&gt;: <br>15<br>Following schedules contain the input point 15:<br>p2 [2, 15] p3 [12, 20] <br><br>1. Insert Schedule<br>2. Delete Schedule<br>3. Find Overlapping Schedules<br>4. Schedules Containing Point<br>5. Print Tree Stats<br>6. Show Tree Viewer<br>7. Quit Program<br><br>Enter Choice: 7<br>Good Bye!</pre>
<p><strong>The GUI: IntervalTreeGUI</strong></p>
<p>This class defines a Graphical User Interface (GUI) viewer. You can use this class as part of your development efforts. &nbsp;It will show you three levels of your interval tree. You don't have to use or modify this class. &nbsp;But, it may help you visualize what the next three levels including the specified IntervalNode. &nbsp;Such visualizations are especially useful if things are not working as expected. You can traverse the tree using this GUI. Just click on any node and it will show next three levels from that node onward. Click the red button to go back to the root of the tree.</p>
<p><strong>CAUTION: Remove all calls to "view" nodes using this GUI before submitting your work. &nbsp; DO NOT HAND IN THE IntervalTreeGUI class.</strong>&nbsp;</p>
<p><a name="Javadocs"></a></p>
<h2>
<span style="font-family: monospace;"></span>Javadocs</h2>
<p>See&nbsp;<a class="" title="" href="http://pages.cs.wisc.edu/~cs367-1/assignments/p4/javadocs/index.html" target="docs">javadocs</a> for all classes provided to you.</p>
<p><span style="color: red;">You may <strong><em>not</em></strong> add any other public methods than those listed in the provided files.</span></p>
<p><span style="color: red;">You may add private (non-static) data members and private helper methods as needed.</span></p>
<p><span style="color: red;">Do&nbsp;<strong><em>not</em></strong> modify any provided class in any way except where noted as "//TODO".</span></p>
<div>
<a name="Steps"></a>
<h2>Steps</h2>
<p>After you have read this program page and given thought to the problem we suggest the following steps:</p>
<ul>
<li>Your p4 team will be responsible for a single submission. &nbsp;Though, we do recommend that all teammates be sure to check and submit well before the due date to ensure that there are no sad faces if the one who said they would submit does not submit successfully.</li>
<li>Review the <a href="/courses/23073/pages/program-commenting-guide" data-api-endpoint="https://canvas.wisc.edu/api/v1/courses/23073/pages/program-commenting-guide" data-api-returntype="Page">commenting</a> and <a href="/courses/23073/pages/program-style-guide" data-api-endpoint="https://canvas.wisc.edu/api/v1/courses/23073/pages/program-style-guide" data-api-returntype="Page">style</a> standards that are used to evaluate your program.</li>
<li>You may use the Java development environment of your choice in CS 367. <em>However, all programs must compile and run on the lab computers for grading.</em> If you are going to use the CS lab computers, we recommend that you use Eclipse. You may want to review the <a href="http://pages.cs.wisc.edu/%7Ecs302/labs/EclipseTutorial/" target="_tab">Eclipse tutorial</a> to learn the basics. Note that on the Linux lab computers, you should enter "eclipse&amp;" at the prompt instead of what is described in the tutorial.</li>
<li>
<strong>Download this <a class="" title="" href="http://pages.cs.wisc.edu/~cs367-1/assignments/p4/files/p4.zip" target="">p4.zip</a> file to a programming assignment p4 folder that you make.&nbsp;</strong>&nbsp;Unzip to place all files in your p4 program folder.</li>
<li>Write test classes and test methods to see if the classes and methods that you are defining work as you intend.</li>
<li>Work on code that is the least dependent upon other code working first. &nbsp;A good order for this program is:
<ul>
<li>define class Interval&nbsp;</li>
<li>complete class IntervalNode&nbsp;</li>
<li>define IntervalTree&nbsp;</li>
</ul>
</li>
<li>There is no need to complete an entire class before testing. &nbsp;It is best if you work on small parts and completely test those parts before moving on to other parts.</li>
<li>If you are not using the lab computers to develop your program, make sure you compile and run your program to ensure that it works on the Linux lab computers. You can compile your Java source using javac in a terminal window as in this example:</li>
<li>
<ul>
<li>javac *.java</li>
<li>and then run your program using java:
<ul>
<li>For interactive mode (use this to run in interactive mode and iteratively develop your program): <br><strong>java IntervalTreeMain 1<br><br></strong>
</li>
<li>For non-interactive mode: <br><strong>java IntervalTreeMain 2 data_01.txt<br><br></strong>
</li>
</ul>
</li>
</ul>
</li>
<li>Submit your work for grading. We will thoroughly test individual classes and run end-to-end tests on your entire program (using the files we provided).
<ul>
<li>Program's robustness for handling null keys<a name="Submission"></a>&nbsp;and throwing appropriate exceptions</li>
</ul>
</li>
</ul>
</div>
<div>
<h2>Submitting Your Work</h2>
<ul>
<li>
<strong>CAUTION: If you have not logged in to Canvas within the last 30 minutes, your handin may not complete due to a session timeout. &nbsp;To avoid this:</strong>
<ol>
<li><strong>Log out of Canvas</strong></li>
<li><strong>Log back in to Canvas</strong></li>
<li><strong>This will refresh your session and ensure that there will not be a timeout while you are submitting files.</strong></li>
</ol>
</li>
<li>
<ul></ul>
Late work is not accepted.</li>
<li>Make sure your code follows the <a class="" title="Program Style Guide" href="/courses/23073/pages/program-style-guide" target="" data-api-endpoint="https://canvas.wisc.edu/api/v1/courses/23073/pages/program-style-guide" data-api-returntype="Page">style</a>&nbsp;and <a class="" title="Program Commenting Guide" href="/courses/23073/pages/program-commenting-guide" target="" data-api-endpoint="https://canvas.wisc.edu/api/v1/courses/23073/pages/program-commenting-guide" data-api-returntype="Page">commenting</a>&nbsp;standards.</li>
<li>Make sure your program runs on the CS Linux workstations (Rm 1366 CS)</li>
<li>All classes must&nbsp;belong to the default package. (No package declaration at top of class).</li>
<li>Submit the following files:</li>
<li>
<ul>
<li>IntervalTree.java</li>
<li>IntervalNode.java</li>
<li>Interval.java&nbsp;</li>
</ul>
</li>
<li>Double-check that the files that you submitted are the work you wanted graded. &nbsp;We will not accept late work. &nbsp;We can only grade work that you submit successfully before the due date and time.</li>
</ul>
<p>&nbsp;</p>
</div></div>


  <div style="display: none;">
    <span class="timestamp">1492398000</span>
    <span class="due_date_string">04/16/2017</span>
    <span class="due_time_string">10:00pm</span>
  </div>
</div>
