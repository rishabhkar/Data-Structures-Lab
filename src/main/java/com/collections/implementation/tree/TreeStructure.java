package com.collections.implementation.tree;

import com.collections.implementation.list.*;
import com.sun.source.tree.*;

import java.util.ArrayList;

public class TreeStructure {

      int data;
      java.util.List<TreeStructure> children;

      public TreeStructure(int data) {
            this.data = data;
            this.children = new ArrayList<>();
      }
}
