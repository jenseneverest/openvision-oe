FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# override the default interfaces config
SRC_URI += "\
          file://interfaces \
          "

PACKAGE_ARCH = "${MACHINE_ARCH}"

INITSCRIPT_PARAMS = "start 10 2 3 4 5 . stop 80 0 6 1 ."
