SRC_URI = "git://github.com/OpenVisionE2/gstreamer1.0-plugin-multibox-dvbmediasink.git"

EXTRA_OECONF = "${DVBMEDIASINK_CONFIG} --with-gstversion=${GSTVERSION} --with-boxtype=${MACHINE} --with-boxbrand=${BOX_BRAND} --with-stbplatform=${STB_PLATFORM}"
