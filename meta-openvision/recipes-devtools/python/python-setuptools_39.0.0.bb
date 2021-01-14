require python-setuptools.inc

PROVIDES = "python-distribute"

inherit setuptools

RREPLACES_${PN} = "python-distribute"
RPROVIDES_${PN} = "python-distribute"
RCONFLICTS_${PN} = "python-distribute"

SRC_URI[md5sum] = "379642a4f17214071fdc1894255d8d11"
SRC_URI[sha256sum] = "94dc566247f35009ed42c0f4422f2b4f0a032fab1372c8308b864c8f26d93388"
