package ggm.trees;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree(0);
        tree.setLeft(new BinaryTree(1));
        tree.setRight(new BinaryTree(2));
        tree.getLeft().setLeft(new BinaryTree(3));
        tree.getLeft().setRight(new BinaryTree(4));
        tree.getRight().setLeft(new BinaryTree(5));
        tree.getRight().setRight(new BinaryTree(6));
        tree.getRight().getRight().setRight(new BinaryTree(7));
        tree.getRight().getRight().getRight().setRight(new BinaryTree(8));

        System.out.println("Total nodes RECURSIVE: " + tree.countNodesRecursive());
        System.out.println("Total nodes ITERATIVE: " + tree.countNodesIterative());
        System.out.println("Total leaves RECURSIVE: " + tree.countLeavesRecursive());
        System.out.println("Total leaves ITERATIVE: " + tree.countLeavesIterative());
        System.out.println("Total intetrnal nodes ITERATIVE: " + tree.countInternalNodesIterative());

        BinaryTree<String> expressionTree = buildExpressionTree("3 41 + 12 3 + *");
        int result = evaluateExpressionTree(expressionTree);
        System.out.println("Result: " + result);
        
    }

    private static int operate(int resultLeft, int resultRight, String operator) {
        return switch (operator) {
            case "+" -> resultLeft + resultRight;
            case "-" -> resultLeft - resultRight;
            case "*" -> resultLeft * resultRight;
            case "/" -> resultLeft / resultRight;
            default -> -1;
        };
    }

    public static BinaryTree<String> buildExpressionTree(String expression) {
        String[] tokens = expression.split(" ");
        Stack<BinaryTree<String>> s = new Stack<>();
        for (String token : tokens) {
            BinaryTree<String> b = new BinaryTree<>(token);
            if (isOperator(token)) {
                b.setRight(s.pop());
                b.setLeft(s.pop());
            }
            s.push(b);
        }
        return s.pop();
    }

    public static int evaluateExpressionTree(BinaryTree<String> expressionTree) {
        if (expressionTree.isLeaf()) {
            return Integer.parseInt(expressionTree.getRoot());
        }
        int resultLeft = 0;
        int resultRight = 0;
        if (expressionTree.getLeft() != null) {
            resultLeft = evaluateExpressionTree(expressionTree.getLeft());
        }
        if (expressionTree.getRight() != null) {
            resultRight = evaluateExpressionTree(expressionTree.getRight());
        }
        return operate (resultLeft, resultRight, expressionTree.getRoot());
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

}
