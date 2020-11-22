SUMMARY = "Firmware files for RPi"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "all"
INSANE_SKIP_${PN} = "arch"

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/rpi-firmwares.tar.xz"

SRC_URI[md5sum] = "1f72cc935973d9fd3194933d664771ac"
SRC_URI[sha256sum] = "f8fe3f61118aa8599da9b1360d884c7d30cbeba75b7b4c94989a2ad8153374dd"

S = "${WORKDIR}/rpi-firmwares"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    cp -r  --preserve=mode,links ${S}/* ${D}${nonarch_base_libdir}/firmware/
}
