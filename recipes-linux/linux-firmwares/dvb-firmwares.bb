SUMMARY = "DVB Firmware files"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PACKAGE_ARCH = "all"
INSANE_SKIP_${PN} = "arch"

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/dvb-firmwares.tar.xz"

SRC_URI[md5sum] = "99a49e8012d5079b688d9bc420783297"
SRC_URI[sha256sum] = "d5f88aeb7b7a1206fa011af218c228ee74e514f730705be865f674f741614a0f"

S = "${WORKDIR}/dvb-firmwares"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    cp -r  --preserve=mode,links ${S} ${D}${nonarch_base_libdir}/firmware
}
