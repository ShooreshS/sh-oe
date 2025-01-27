# meta-yourlayer/recipes-core/images/my-image.bb
DESCRIPTION = "Shooresh Image"
LICENSE = "MIT"

# Inherit the base image class
inherit core-image

# Additional packages or features to include
IMAGE_FEATURES += "splash package-management x11-base x11-sato ssh-server-dropbear hwcodecs"
IMAGE_INSTALL += "nano curl pcmanfm xterm"


QB_MEM = '${@bb.utils.contains("DISTRO_FEATURES", "opengl", "-m 1024", "-m 512", d)}'
QB_MEM:qemuarmv5 = "-m 512"
QB_MEM:qemumips = "-m 512"
