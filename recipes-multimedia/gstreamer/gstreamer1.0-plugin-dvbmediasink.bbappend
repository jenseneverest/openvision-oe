SRC_URI = "${@bb.utils.contains("MACHINE_FEATURES", "azbox", "git://github.com/OpenVisionE2/gstreamer1.0-plugin-azbox-dvbmediasink.git", "git://github.com/OpenVisionE2/gstreamer1.0-plugin-multibox-dvbmediasink.git", d)}"

EXTRA_OECONF = "${DVBMEDIASINK_CONFIG} --with-gstversion=${GSTVERSION} --with-boxtype=${MACHINE} --with-boxbrand=${BOX_BRAND}"
