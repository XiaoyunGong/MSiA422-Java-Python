import timeit
import time


class MySorted:
    def __init__(self):
        #self.imput = imput
        #self.key = key
        #self.reverse = reverse
        self.bubble_time = 0
        self.merge_time = 0
        self.comp = 0


    def bubble_sorted(self, imput, key = lambda x:x, reverse = False):
        '''
        This function returns the sorted imput using bubble sort.
        '''
        swap = 0
        self.comp = 0
        start_time = time.time()
        n = len(imput)
        #imput_key = list(map(key, imput))
        if reverse:
            cmp = lambda m,n: key(m) <= key(n)
            #cmp = lambda m,n: m <= n
        else:
            cmp = lambda m,n: key(m) >= key(n)
            #cmp = lambda m,n: m >= n
        #mydict = dict(zip(imput_key, imput))

        if isinstance(imput, dict):
            imput = list(imput.keys())
        if isinstance(imput, tuple):
            imput = list(imput)

        for i in range(n-1):
            for j in range(0, n-i-1):
                self.comp += 1
                #if cmp(imput_key[j], imput_key[j+1]):
                if cmp(imput[j], imput[j+1]):
                    #imput_key[j], imput_key[j + 1] = imput_key[j + 1], imput_key[j]
                    imput[j], imput[j + 1] = imput[j + 1], imput[j]
                    swap += 1
        #result = [mydict[key] for key in imput_key]

        end_time = time.time()
        self.bubble_time = end_time - start_time
        #reList = [result, self.comp, swap, self.bubble_time]
        reList = [imput, self.comp, swap, self.bubble_time]
        return reList

    def _mergeSort(self, arr, cmp):
        if len(arr) > 1:
            mid = len(arr)//2
            L = arr[:mid]
            R = arr[mid:]
            self._mergeSort(L, cmp)
            self._mergeSort(R, cmp)
            i = j = k = 0
            while i < len(L) and j < len(R):
                self.comp += 1
                if cmp(L[i],R[j]):
                    arr[k] = L[i]
                    i += 1
                    
                else:
                    arr[k] = R[j]
                    j+= 1
                    #self.comp += 1
                k += 1

            while i < len(L):
                arr[k] = L[i]
                i += 1
                k += 1

            while j < len(R):
                arr[k] = R[j]
                j += 1
                k += 1

    def merge_sorted(self, imput, key = lambda x:x, reverse = False):
        start = time.time()
        swap = 0
        self.comp = 0
        if reverse:
            cmp = lambda m,n: key(m) >= key(n)
        else:
            cmp = lambda m,n: key(m) <= key(n)
        if isinstance(imput, dict):
            imput = list(imput.keys())
        if isinstance(imput, tuple):
            imput = list(imput)
        #imput_key = list(map(key, imput))
        #mydict = dict(zip(imput_key, imput))
        self._mergeSort(imput, cmp)
        #result = [mydict[key] for key in imput_key]
        end = time.time()
        self.merge_time = end - start
        #reList = [result, self.comp, swap, self.merge_time]
        reList = [imput, self.comp, swap, self.merge_time]
        return reList