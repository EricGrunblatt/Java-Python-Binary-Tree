class BinaryTree(object):

    def __init__(self, data = None, left = None, right = None):
        self.data = data
        self.left = left
        self.right = right

    @property
    def data(self):
        return self.__data

    @data.setter
    def data(self, data):
        self.__data = data

    def add_leftchild(self, tree):
        if type(tree.data) == type(self.data):
            self.left = tree

    def add_rightchild(self, tree):
        if type(tree.data) == type(self.data):
            self.right = tree
        else:
            raise TypeError('Type mismatch between ' + type(self.data).__name__ + ' and ' + type(tree.data).__name__)

    def preorder(self):
        if self.data is not None:
            yield self.data
        if self.left is not None:
            for d in self.left.preorder():
                yield d
        if self.right is not None:
            for d in self.right.preorder():
                yield d

    def __iter__(self):
        output = self.preorder()
        return output

