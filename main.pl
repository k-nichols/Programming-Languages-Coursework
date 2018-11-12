#!/usr/bin/perl
# Programming Language Structures - Assignment 6 - PERL version
# -------------------------------------------------------------
# Kathleen Near
# CSC471-M01
# 10/29/18
#
# Description:
# You are given data that has been through a "backup" program which, at times, added extraneous data.
# This added data has a pattern: it ALWAYS starts with a CONTROL-C and ends in a CONTROL-B.
# After the CONTROL-C, there may be more Control-C characters as part of the extraneous data.
# Write programs in PERL, JAVA, and PYTHON which remove these values from the text file.

use strict;
use warnings;

my $char;
my $read;
my $flag = 1;
open(FILE, "<control-char.txt") or die "Could not open file 'FILE'";
while($read = read FILE, $char, 1) {
    if(ord($char) == 3) {
        $flag = 0;
    } elsif (ord($char) == 2) {  
        $flag = 1;
    } else {
        if($flag) {
            print $char;
        }
    }
}
close FILE;
