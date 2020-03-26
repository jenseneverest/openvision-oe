SUMMARY = "Firmware files for RPi"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "all"
INSANE_SKIP_${PN} = "arch"

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/rpi-firmwares.tar.xz"

SRC_URI[md5sum] = "aa9d913a81b8d50904227fb79b42c65a"
SRC_URI[sha256sum] = "8e5161479bbce2b43127b9636f3997cc5bbf08ebc38370e6c51c42d95c0c40e2"

S = "${WORKDIR}/rpi-firmwares"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    cp -r  --preserve=mode,links ${S}/* ${D}${nonarch_base_libdir}/firmware/
}
