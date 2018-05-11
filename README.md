Katalon Studio Custom Keyword: WebElementListVerifier#verifySortedReverse()
=====

This is a small [Katalon Studio](https://www.katalon.com/) project for demonstration purpose.
You can clone this out on your PC and execute it with your Katalon Studio.

This project is developed to propose a solution for the following discussion:

- https://forum.katalon.com/discussion/6597/is-there-anyway-to-test-sorting-functionality-of-a-web-table

# Problem to solve

I want to verify the order of rows a HTML TABLE.
I want to check if a table is ordered natual or ordered reversed.

I mean 'table sorted natual' as following:

|:---|
| Alfreds Futterkiste |
| Centro comercial Moctezuma |
| Ernst Handel |
| Laughing Bacchus Winecellars |
| Magazzini Alimentari Riuniti |

I mean 'table sorted reverse' as following:

|:---|
| Magazzini Alimentari Riuniti |
| Laughing Bacchus Winecellars |
| Ernst Handel |
| Centro comercial Moctezuma |
| Alfreds Futterkiste |

# Custom keywords

This project developped two custom keywords:

1. `mypackage.WebElementListVerifier#verifySortedNatual(List<WebElement> list)`
2. `mypackage.WebElementListVerifier#verifySortedReverse(List<WebElement> list)`

# How to use custom keywords

You can find example how to use the custom keywords in [TC2_verifyTableRowOrder](https://github.com/kazurayam/KatalonDiscussion6597/blob/master/Scripts/TC2_verifyTableRowOrder/Script1525936565404.groovy)
