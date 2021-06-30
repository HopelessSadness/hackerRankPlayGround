package com.hackerrRank;

import java.util.HashMap;
import java.util.Map;

public class CTCIContacts {
    private static class ContactTrie {
        SymbolTrieNode root = new SymbolTrieNode();

        public void addContact(String contact) {
            SymbolTrieNode currentNode = root;
            for (char symbol : contact.toCharArray()) {
                currentNode.putChildrenChar(symbol);
                currentNode = currentNode.getChildrenSymbolNode(symbol);
                currentNode.incrementCount();
            }
        }

        public int findCountBySymbolSequence(String sequence) {
            SymbolTrieNode currentNode = root;
            for (char symbol : sequence.toCharArray()) {
                currentNode = currentNode.getChildrenSymbolNode(symbol);
                if (currentNode == null) return 0;
            }

            return currentNode.getChildrenSymbolsCount();
        }
    }

    private static class SymbolTrieNode {
        private Map<Character, SymbolTrieNode> childrenChars = new HashMap<>();
        private int childrenSymbolsCount = 0;

        public void putChildrenChar(char symbol) {
            if (!childrenChars.containsKey(symbol)) {
                childrenChars.put(symbol, new SymbolTrieNode());
            }
        }

        public SymbolTrieNode getChildrenSymbolNode(char symbol) {
            return childrenChars.get(symbol);
        }

        public int getChildrenSymbolsCount() {
            return childrenSymbolsCount;
        }

        public void incrementCount() {
            childrenSymbolsCount++;
        }
    }

    public static void main(String[] args) {
        ContactTrie contactTrie = new ContactTrie();

        contactTrie.addContact("s");
        contactTrie.addContact("ss");
        contactTrie.addContact("sss");

        System.out.println(contactTrie.findCountBySymbolSequence("s"));
        System.out.println(contactTrie.findCountBySymbolSequence("ss"));
        System.out.println(contactTrie.findCountBySymbolSequence("sss"));
        System.out.println(contactTrie.findCountBySymbolSequence("ssss"));
    }
}