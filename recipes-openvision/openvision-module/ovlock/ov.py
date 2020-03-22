def gettitle():
    try:
        f = open('/proc/stb/info/openvision', 'r')
        data = []
        data = f.readlines()
        for line in data:
            if 'https://openvision.tech' in line:
                return True

        return False
        f.close()
    except:
        return False
