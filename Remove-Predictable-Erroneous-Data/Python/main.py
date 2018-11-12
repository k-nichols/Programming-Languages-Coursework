#!/usr/bin/env python
# Programming Language Structures - Assignment 6 - Python version
# ---------------------------------------------------------------
# Kathleen Near
# CSC471-M01
# 10/29/18
#
# Description:
# You are given data that has been through a "backup" program which, at times, added extraneous data.
# This added data has a pattern: it ALWAYS starts with a CONTROL-C and ends in a CONTROL-B.
# After the CONTROL-C, there may be more Control-C characters as part of the extraneous data.
# Write programs in PERL, JAVA, and PYTHON which remove these values from the text file.

from __future__ import print_function

flag = 1;
with open('control-char.txt') as f:
    while True:
        char = f.read(1)
        if not char:
            break
        elif ord(char) == 3:
            flag = 0
        elif ord(char) == 2:
            flag = 1
        else:
            if(flag): print(char, end = "")
