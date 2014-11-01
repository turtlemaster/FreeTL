#!/bin/sh

echo "Copy+Paste the following lines:"
echo "connect 'jdbc:derby:/Users/turtlemaster/Programming/FreeTL/db/freetl';"
echo "set schema sa;"
echo
echo "Type help for more info"
export DERBY_HOME=/Users/turtlemaster/Programming/db-derby-10.11.1.1-bin/
/Users/turtlemaster/Programming/db-derby-10.11.1.1-bin/bin/ij
