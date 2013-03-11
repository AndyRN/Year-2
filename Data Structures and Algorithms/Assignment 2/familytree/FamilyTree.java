package familytree;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Once complete this class manages a family tree. You need to complete the
 * methods whose headers are given here.
 *
 * @author cjberry
 */
public class FamilyTree {

  private ArrayList<Person> treeArray = new ArrayList();

  public FamilyTree() {
  }

  /**
   * Adds a person to the family tree
   *
   * @param aPerson Person to be added
   */
  public void addPerson(Person aPerson) {
    treeArray.add(aPerson);
    System.out.println("--- " + aPerson.getName() + " has been added to the family tree ---");
  }

  /**
   * Links an individual to their mother. Both the individual and the mother
   * need already to appear as a Person in the family tree.
   *
   * @param aPerson String holding individual's name
   * @param aDOB String holding individual's date of birth
   * @param mName String holding mother's name
   * @param mDOB String holding mother's date of birth
   */
  public void makeLinkToMother(String aPerson, String aDOB,
          String mName, String mDOB) {
    int i = personPos(aPerson, aDOB);//Returns the position of the person object in the array.
    int m = personPos(mName, mDOB);
    if (i == -1) {
      System.out.println("\n[Person does not exist]");
    } else {
      try {
        treeArray.get(i).addParent(treeArray.get(m));//Adds the parent into their parent array.
        treeArray.get(i).setmPos(m);//The person now knows the "mother" object's position.    
        System.out.println("--- " + aPerson + "'s mother is now " + mName + " ---");
      } catch (Exception e) {
        System.out.println("\n[Mother does not exist]");
      }
    }//if(exists)
  }//makeLinkToMother()

  /**
   * Links an individual to their father. Both the individual and the mother
   * need already to appear as a Person in the family tree.
   *
   * @param aPerson String holding individual's name
   * @param aDOB String holding individual's date of birth
   * @param fName String holding father's name
   * @param fDOB String holding father's date of birth
   */
  public void makeLinkToFather(String aPerson, String aDOB,
          String fName, String fDOB) {
    int i = personPos(aPerson, aDOB);//Returns the position of the person object in the array.
    int f = personPos(fName, fDOB);
    if (i == -1) {
      System.out.println("\n[Person does not exist]");
    } else {
      try {
        treeArray.get(i).addParent(treeArray.get(f));//Adds the parent into their parent array.
        treeArray.get(i).setfPos(f);//The person now knows the "father" object's position. 
        System.out.println("--- " + aPerson + "'s father is now " + fName + " ---");
      } catch (Exception e) {
        System.out.println("\n[Father does not exist]");
      }
    }//if(exists)
  }//makeLinkToFather()

  /**
   * Links a newly married couple. Each member of the couple needs already to
   * appear as a Person in the family tree.
   *
   * @param partner1Name String holding bride's name
   * @param aDOB1 String holding bride's date of birth
   * @param partner2Name String holding groom's name
   * @param aDOB2 String holding groom's date of birth
   */
  public void recordWedding(String partner1Name, String aDOB1,
          String partner2Name, String aDOB2) {
    int i = personPos(partner1Name, aDOB1);//Returns the position of the person object in the array.
    int p = personPos(partner2Name, aDOB2);
    try {
      treeArray.get(i).setpPos(p);//Both partners now know each others position.
      treeArray.get(i).setMarried(true);
      treeArray.get(p).setpPos(i);
      treeArray.get(p).setMarried(true);
      treeArray.get(i).addPartner(treeArray.get(p));//Both partners have each other
      treeArray.get(p).addPartner(treeArray.get(i));//added to their relationship arrays.
      System.out.println("--- " + partner1Name + " is now married to " + partner2Name + " ---");
    } catch (Exception e) {
      System.out.println("\n[One or both partners do not exist]");
    }
  }//recordWedding()

  /**
   * Records a divorce. Each member of the couple needs already to appear as a
   * Person in the family tree.
   *
   * @param partner1Name String holding wife's name
   * @param aDOB1 String holding wife's date of birth
   * @param partner2Name String holding husband's name
   * @param aDOB2 String holding husband's date of birth
   */
  public void recordDivorce(String partner1Name, String aDOB1,
          String partner2Name, String aDOB2) {
    int i = personPos(partner1Name, aDOB1);//Returns the position of the person object in the array.
    int p = personPos(partner2Name, aDOB2);
    try {
      treeArray.get(i).setpPos(-1);//Both partners no longer have a partner.
      treeArray.get(i).setMarried(false);
      treeArray.get(p).setpPos(-1);
      treeArray.get(p).setMarried(false);
      treeArray.get(i).setDpPos(p);//Both divorced partners now know each others position.
      treeArray.get(p).setDpPos(i);
      System.out.println("--- " + partner1Name + " is now divorced from " + partner2Name + " ---");
    } catch (Exception e) {
      System.out.println("\n[One or both partners do not exist]");
    }
  }//recordDivorce()

  /**
   * List the details of the person whose name is given. Note you need to do
   * something about the possibility of duplicate names appearing.
   *
   * @param personName
   */
  public void listPersonDetails(String personName) {
    int i = personPos(personName);//Returns the position of the person object in the array.
    if (i == -1) {
      System.out.println("\n[Person does not exist]");
    } else {
      treeArray.get(i).details();
    }//if(exists)
  }//listPersonDetails()

  /**
   * List the details of the parent of the person whose name is given. Note you
   * need to do something about the possibility of duplicate names appearing.
   *
   * @param personName
   */
  public void listParentDetails(String personName) {
    int i = personPos(personName);//Returns the position of the person object in the array.
    if (i == -1) {
      System.out.println("\n[Person does not exist]");
    } else {
      try {
        int mother = treeArray.get(i).getmPos();//Returns the position of the mother object in the array.
        System.out.print("\n--- Mother ---");
        treeArray.get(mother).details();
      } catch (Exception e) {
        System.out.println("\n[Mother does not exist]");
      }
      try {
        int father = treeArray.get(i).getfPos();//Returns the position of the father object in the array.
        System.out.print("\n--- Father ---");
        treeArray.get(father).details();
      } catch (Exception e) {
        System.out.println("\n[Father does not exist]");
      }
    }//if(exists)
  }//listParentDetails()

  /**
   * List the details of the children of the person whose name is given. Note
   * you need to do something about the possibility of duplicate names
   * appearing.
   *
   * @param personName
   */
  public void listChildren(String personName) {
    int i = personPos(personName);//Returns the position of the person object in the array.
    if (i == -1) {
      System.out.println("\n[Person does not exist]");
    } else {
      boolean child = false;
      //This loop finds all person objects that have their fPos or mPos pointing at the person requested.
      for (int c = 0; c < treeArray.size(); c++) {
        if (treeArray.get(c).getfPos() == i || treeArray.get(c).getmPos() == i) {
          System.out.print("\n--- Child ---");
          treeArray.get(c).details();
          child = true;
        }
      }//for(child)
      if (!child) {
        System.out.println("\n[" + personName + " has no children]");
      }
    }//if(exists)
  }//listChildren()

  /**
   * List the details of the siblings of the person whose name is given. Note
   * you need to do something about the possibility of duplicate names
   * appearing.
   *
   * @param personName
   */
  public void listSiblings(String personName) {
    int i = personPos(personName);//Returns the position of the person object in the array.
    if (i == -1) {
      System.out.println("\n[Person does not exist]");
    } else {
      int father = treeArray.get(i).getfPos();//Returns the position of the father object in the array.
      int mother = treeArray.get(i).getmPos();//Returns the position of the mother object in the array.
      boolean sibling = false;
      //This loop finds all person objects that have their fPos or mPos pointing at the person requested's fPos or mPos.
      for (int s = 0; s < treeArray.size(); s++) {
        if (((treeArray.get(s).getfPos() == father && father != -1)
                || (treeArray.get(s).getmPos() == mother && mother != -1))
                && s != i) {
          System.out.print("\n--- Sibling ---");
          treeArray.get(s).details();
          sibling = true;
        }
      }//for(siblings)
      if (!sibling) {
        System.out.println("\n[" + personName + " has no siblings]");
      }
    }//if(exists)
  }//listSiblings()

  /**
   * List the details of the ancestors along the paternal line of the person
   * whose name is given. Note you need to do something about the possibility of
   * duplicate names appearing.
   *
   * @param personName
   */
  public void listPaternalLineage(String personName) {
    int i = personPos(personName);//Returns the position of the person object in the array.
    if (i == -1) {
      System.out.println("\n[Person does not exist]");
    } else {
      System.out.print("\nPaternal Lineage =");
      System.out.println("- " + treeArray.get(i).getName() + " " + treeArray.get(i).getdOB());
      int father = treeArray.get(i).getfPos();
      while (father != -1) {//While the next object has a father linked.
        System.out.println("- " + treeArray.get(father).getName() + " " + treeArray.get(father).getdOB());
        father = treeArray.get(father).getfPos();
      }//while(father)
    }//if(exists)
  }//listPaternalLineage()

  /**
   * List the details of the ancestors along the maternal line of the person
   * whose name is given. Note you need to do something about the possibility of
   * duplicate names appearing.
   *
   * @param personName
   */
  public void listMaternalLineage(String personName) {
    int i = personPos(personName);//Returns the position of the person object in the array.
    if (i == -1) {
      System.out.println("\n[Person does not exist]");
    } else {
      System.out.print("\nMaternal Lineage =");
      System.out.println("- " + treeArray.get(i).getName() + " " + treeArray.get(i).getdOB());
      int mother = treeArray.get(i).getmPos();
      while (mother != -1) {//While the next object has a mother linked.
        System.out.println("- " + treeArray.get(mother).getName() + " " + treeArray.get(mother).getdOB());
        mother = treeArray.get(mother).getmPos();
      }//while(father)
    }//if(exists)
  }//listMaternalLineage()

  /**
   * List the details of the grandparents of the person whose name is given.
   * Note you need to do something about the possibility of duplicate names
   * appearing.
   *
   * @param personName
   */
  public void listGrandParents(String personName) {
    int i = personPos(personName);//Returns the position of the person object in the array.
    if (i == -1) {
      System.out.println("\n[Person does not exist]");
    } else {
      int mother = treeArray.get(i).getmPos();//Returns the position of the mother object in the array.
      try {
        int Mgrandmother = treeArray.get(mother).getmPos();//Returns the position of the mother's mother object in the array.
        int Mgrandfather = treeArray.get(mother).getfPos();//Returns the position of the mother's father object in the array.

        System.out.println("\n[Maternal Side]");
        System.out.print("--- Grandmother ---");
        treeArray.get(Mgrandmother).details();

        System.out.print("\n--- Grandfather ---");
        treeArray.get(Mgrandfather).details();
      } catch (Exception e) {
        System.out.println("\n[" + personName + " has no grandparents on their maternal side]");
      }

      int father = treeArray.get(i).getfPos();//Returns the position of the father object in the array.
      try {
        int Pgrandmother = treeArray.get(father).getmPos();//Returns the position of the father's mother object in the array.
        int Pgrandfather = treeArray.get(father).getfPos();//Returns the position of the father's father object in the array.

        System.out.println("\n[Paternal Side]");
        System.out.print("--- Grandmother ---");
        treeArray.get(Pgrandmother).details();

        System.out.print("--- Grandfather ---");
        treeArray.get(Pgrandfather).details();
      } catch (Exception e) {
        System.out.println("\n[" + personName + " has no grandparents on their paternal side]");
      }
    }//if(exists)
  }//listGrandParents()

  /**
   * List the details of the grandchildren of the person whose name is given.
   * Note you need to do something about the possibility of duplicate names
   * appearing.
   *
   * @param personName
   */
  public void listGrandChildren(String personName) {
    ArrayList<Person> grandchildArray = new ArrayList();//Stores all found grandchildren found.
    int i = personPos(personName);//Returns the position of the person object in the array.
    if (i == -1) {
      System.out.println("\n[Person does not exist]");
    } else {
      boolean grandchild = false;
      boolean fail;
      for (int c = 0; c < treeArray.size(); c++) {//This loop finds all the person's children.
        if (treeArray.get(c).getfPos() == i || treeArray.get(c).getmPos() == i) {
          for (int gc = 0; gc < treeArray.size(); gc++) {//This loop finds all the children's children.
            if ((treeArray.get(gc).getfPos() == c || treeArray.get(gc).getmPos() == c) && c != -1) {
              fail = false;
              for (int x = 0; x < grandchildArray.size(); x++) {//This loop checks if the grandchild has already been added.
                if (treeArray.get(gc).getName().equals(grandchildArray.get(x).getName())
                        && treeArray.get(gc).getdOB().equals(grandchildArray.get(x).getdOB())) {
                  fail = true;
                }
              }//for
              if (!fail) {
                System.out.print("\n--- Grandchild ---");
                treeArray.get(gc).details();
                grandchildArray.add(treeArray.get(gc));
                grandchild = true;
              }
            }//if
          }//for(grandchild)
        }//if
      }//for(child)
      if (!grandchild) {
        System.out.println("\n[" + personName + " has no grandchildren]");
      }
    }//if(exists)
  }//listGrandChildren()

  /**
   * List the details of the cousins of the person whose name is given. Note you
   * need to do something about the possibility of duplicate names appearing.
   *
   * @param personName
   */
  public void listCousins(String personName) {
    ArrayList<Person> cousinArray = new ArrayList();//Stores all cousins found.
    int i = personPos(personName);//Returns the position of the person object in the array.
    if (i == -1) {
      System.out.println("\n[Person does not exist]");
    } else {
      cousinArray.add(treeArray.get(i));
      int mother = treeArray.get(i).getmPos();//Returns the position of the mother object in the array.
      int father = treeArray.get(i).getfPos();//Returns the position of the father object in the array.
      boolean cousin = false;
      boolean fail;

      try {
        int Mgrandmother = treeArray.get(mother).getmPos();//Returns the position of the mother's mother object in the array.
        int Mgrandfather = treeArray.get(mother).getfPos();//Returns the position of the mother's father object in the array.
        for (int s = 0; s < treeArray.size(); s++) {//This loop finds all siblings of the parents.
          if (((treeArray.get(s).getmPos() == Mgrandmother && Mgrandmother != -1)
                  || (treeArray.get(s).getfPos() == Mgrandfather && Mgrandfather != -1))
                  && (s != mother && s != father)) {//Stops the persons siblings from being listed as cousins.
            for (int c = 0; c < treeArray.size(); c++) {//This loop finds all children of the parent's siblings.
              if ((treeArray.get(c).getfPos() == s || treeArray.get(c).getmPos() == s) && s != -1) {
                fail = false;
                for (int x = 0; x < cousinArray.size(); x++) {//This loop checks if the cousin has already been added.
                  if (treeArray.get(c).getName().equals(cousinArray.get(x).getName())
                          && treeArray.get(c).getdOB().equals(cousinArray.get(x).getdOB())) {
                    fail = true;
                  }
                }//for
                if (!fail) {
                  System.out.print("\n--- Cousin ---");
                  treeArray.get(c).details();
                  cousinArray.add(treeArray.get(c));
                  cousin = true;
                }
              }//if
            }//for(cousin)
          }//if
        }//for(Maternal- aunt/uncle)
      } catch (Exception e) {
        System.out.println("\n[" + personName + " has no grandparents on their maternal side]");
      }

      try {
        int Pgrandmother = treeArray.get(father).getmPos();//Returns the position of the father's mother object in the array.
        int Pgrandfather = treeArray.get(father).getfPos();//Returns the position of the father's father object in the array.
        for (int s = 0; s < treeArray.size(); s++) {//This loop finds all siblings of the parents.
          if (((treeArray.get(s).getmPos() == Pgrandmother && Pgrandmother != -1)
                  || (treeArray.get(s).getfPos() == Pgrandfather && Pgrandfather != -1))
                  && (s != mother && s != father)) {//Stops the persons siblings from being listed as cousins.
            for (int c = 0; c < treeArray.size(); c++) {//This loop finds all children of the parent's siblings.
              if ((treeArray.get(c).getfPos() == s || treeArray.get(c).getmPos() == s) && s != -1) {
                fail = false;
                for (int x = 0; x < cousinArray.size(); x++) {//This loop checks if the cousin has already been added.
                  if (treeArray.get(c).getName().equals(cousinArray.get(x).getName())
                          && treeArray.get(c).getdOB().equals(cousinArray.get(x).getdOB())) {
                    fail = true;
                  }
                }//for
                if (!fail) {
                  System.out.print("\n--- Cousin ---");
                  treeArray.get(c).details();
                  cousinArray.add(treeArray.get(c));
                  cousin = true;
                }
              }//if
            }//for(cousin)
          }//if
        }//for(Paternal- aunt/uncle)
      } catch (Exception e) {
        System.out.println("\n[" + personName + " has no grandparents on their paternal side]");
      }

      if (!cousin) {
        System.out.println("\n[" + personName + " has no cousins]");
      }
    }//if(exists)
  }//listCousins()

  /**
   * List the details of the N generations of ancestors of the person whose name
   * is given. Note you need to do something about the possibility of duplicate
   * names appearing.
   *
   * @param personName
   * @param numberOfGenerations 1=parents,2=grandparents, 3=great-grandparents
   * etc.
   */
  public void listGreatNGrandParents(String personName, int numberOfGenerations) {
    ArrayList<Person> ancestorArray = new ArrayList();//Stores all ancestors found.
    int i = personPos(personName);//Returns the position of the person object in the array.
    if (i == -1) {
      System.out.println("\n[Person does not exist]");
    } else {
      System.out.print("\n--- Ancestors ---");
      ancestorArray.add(treeArray.get(i));//Puts the person requested into the array to start the search.
      boolean genAdd = true, countAdd = false;//Booleans to control the flow.
      int generation = -1;
      numberOfGenerations++;
      for (; numberOfGenerations > 0; numberOfGenerations--) {
        int arraysize = ancestorArray.size();
        int count = 0;
        if (!genAdd) {//If a generation was not added the last time, then stop.
          System.out.println("\n[" + personName + " does not have that many generations of ancestors]");
          numberOfGenerations = 0;//This will exit the loop if a user has entered too high of a number.
        } else {
          genAdd = false;
          generation++;

          for (int x = 0; x < arraysize; x++) {//Checks all current ancestors to see if they have parents.
            if (ancestorArray.get(x).getmPos() != -1) {
              ancestorArray.add(treeArray.get(ancestorArray.get(x).getmPos()));//If they have either a mother...
              count++;
              genAdd = true;
            }
            if (ancestorArray.get(x).getfPos() != -1) {
              ancestorArray.add(treeArray.get(ancestorArray.get(x).getfPos()));//...or a father, then the parent is added.
              if (!countAdd) {
                count++;
              }
              genAdd = true;
            }
            countAdd = false;
          }//for(currentAncestors)

          System.out.println("Generation = " + generation);
          for (int x = 0; x < ancestorArray.size() - count; x++) {//This prints out the parents found in the current generation.
            System.out.println("- " + ancestorArray.get(x).getName() + " " + ancestorArray.get(x).getdOB());
            ancestorArray.remove(x);
            x--;
          }
        }//if(generationNotAdded)
      }//for(numberOfGenerations)
    }//if(exists)
  }//listGreatNGrandParents()

  /**
   * List the details of the N generations of children of the person whose name
   * is given. Note you need to do something about the possibility of duplicate
   * names appearing.
   *
   * @param personName
   * @param numberOfGenerations 1=children,2=grandchildren,
   * 3=great-grandchildren etc.
   */
  public void listGreatNGrandChildren(String personName, int numberOfGenerations) {/////////////////////////////    
    ArrayList<Person> successorArray = new ArrayList();//Stores all successors found.
    int i = personPos(personName);//Returns the position of the person object in the array.
    if (i == -1) {
      System.out.println("\n[Person does not exist]");
    } else {
      System.out.println("\n--- Successors ---");
      successorArray.add(treeArray.get(i));//Puts the person requested into the array to start the search.
      boolean genAdd = true, found = false;//Boolean to control the flow.
      int generation = -1;
      numberOfGenerations++;
      for (; numberOfGenerations > 0; numberOfGenerations--) {
        int arraysize = successorArray.size();
        int count = 0;
        if (!genAdd) {//If a generation was not added the last time, then stop.
          System.out.println("\n[" + personName + " does not have that many generations of successors]");
          numberOfGenerations = 0;//This will exit the loop if a user has entered too high of a number.
        } else {
          genAdd = false;
          generation++;

          for (int x = 0; x < arraysize; x++) {//Checks all current successors to see if they have children.
            for (int c = 0; c < treeArray.size(); c++) {
              if (treeArray.get(c).getfPos() != -1) {
                if (treeArray.get(treeArray.get(c).getfPos()).getName().equals(successorArray.get(x).getName())
                        && (treeArray.get(treeArray.get(c).getfPos()).getdOB().equals(successorArray.get(x).getdOB()))) {
                  found = true;
                }
              }//if(fatherExists)
              if (treeArray.get(c).getmPos() != -1) {
                if (treeArray.get(treeArray.get(c).getmPos()).getName().equals(successorArray.get(x).getName())
                        && (treeArray.get(treeArray.get(c).getmPos()).getdOB().equals(successorArray.get(x).getdOB()))) {
                  found = true;
                }
              }//if(motherExists)
              if (found) {
                successorArray.add(treeArray.get(c));//If they have a child, that child is added.
                count++;
                genAdd = true;
                found = false;
              }
            }//for(allPersonObjects)
          }//for(currentSuccessors)

          System.out.println("Generation = " + generation);
          for (int x = 0; x < successorArray.size() - count; x++) {//This prints out the children found in the current generation.
            System.out.println("- " + successorArray.get(x).getName() + " " + successorArray.get(x).getdOB());
            successorArray.remove(x);
            x--;
          }
        }//if(generationNotAdded)
      }//for(numberOfGenerations)
    }//if(exists)
  }//listGreatNGrandChildren()

  /**
   * Records an adoption.
   *
   * @param personName
   * @param aDOB
   */
  public void recordAdoption(String personName, String aDOB) {
    int i = personPos(personName, aDOB);//Returns the position of the person object in the array.
    if (i == -1) {
      System.out.println("\n[Person does not exist]");
    } else {
      treeArray.get(i).setAdopted(true);
      System.out.println("--- " + personName + "'s adopted status is now set to \"true\" ---");
    }//if(exists)
  }//recordAdoption()

  //----------------------- Extra Methods --------------------------------------
  public int personPos(String personName) {
    Scanner responseScan = new Scanner(System.in);
    ArrayList<Person> matchArray = new ArrayList();
    int x = -1, count = 0;
    for (int i = 0; i < treeArray.size(); i++) {//Checks all matches of the person requested.
      if (personName.equals(treeArray.get(i).getName())) {
        matchArray.add(treeArray.get(i));
        count++;
        x = i;
      }
    }//for(personName)
    if (count == 1) {
      return x;
    } else if (count > 1) {
      System.out.println("");
      for (int y = 0; y < matchArray.size(); y++) {//User selects from the possibilites.
        System.out.println((y + 1) + ") " + matchArray.get(y).getName() + " born in " + matchArray.get(y).getdOB());
      }
      System.out.println("\nPlease choose from list of duplicate names : ");
      int response = responseScan.nextInt();
      return personPos(matchArray.get(response - 1).getName(), matchArray.get(response - 1).getdOB());
    }
    return -1;
  }//personID()

  public int personPos(String personName, String aDOB) {
    for (int i = 0; i < treeArray.size(); i++) {
      if (personName.equals(treeArray.get(i).getName())
              && aDOB.equals(treeArray.get(i).getdOB())) {
        return i;
      }
    }//for(personName, aDOB)
    return -1;
  }//personID()
}//FamilyTree.java