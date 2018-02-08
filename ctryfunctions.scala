package cardiff.comsc.miscfunctions
/** ****************************************************************************
  * TreeLeast program.
  * Miscellaneous country-related functions. Created by Alex Hardisty on 1st June 2017.
  * (c) Copyright Cardiff University 2017, 2018.
  *
  * CC BY-SA 4.0. This work is licensed as Creative Commons Attribution-ShareAlike 4.0.
  * A license summary can be found at: https://creativecommons.org/licenses/by-sa/4.0/.
  *
  * *****************************************************************************/
/**
  * General imports
  */

package object ctryFunctions {


  /**
    * selectGbifCountries : Function to select the unique countries where occurrences occur.
    *                      It returns a Set (effectively, a count when .size is used) of the
    *                      countries where GBIF thinks the species occurs
    *
    * @param data an RDD of occurrence records.
    * @return a Set of unique countries.
    *
    */
  def selectGbifCountries(data: Map[String, String]): Set[(String)] = {
    var countries: Set[String] = Set.empty
    countries += data("countryCode")

    // special case: if no countryCode is assigned in a particular record, \N may be present.
    // get rid of this.
        if (countries.contains("""\N""")) countries = countries - """\N"""

    return countries
  }

}

