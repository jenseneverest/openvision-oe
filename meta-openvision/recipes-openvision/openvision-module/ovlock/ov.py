def gettitle():
    try:
        f = open('/proc/openvision/distro', 'r')
        data = []
        data = f.readlines()
        for line in data:
            if 'openvision' in line:
                return True

        return False
        f.close()
    except:
        return False
